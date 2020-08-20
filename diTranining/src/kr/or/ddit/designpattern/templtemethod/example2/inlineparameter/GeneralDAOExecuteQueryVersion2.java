package kr.or.ddit.designpattern.templtemethod.example2.inlineparameter;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.designpattern.templtemethod.example2.typehandler.ITypeHandler;

public class GeneralDAOExecuteQueryVersion2<T> extends ExecuteQueryTemplateVersion2<T> {
	
	private Class<T> resultClass;
	public GeneralDAOExecuteQueryVersion2(Class<T> resultClass) {
		this.resultClass = resultClass;
	}
	
	@Override
	protected List<T> executeQuery(PreparedStatement pstmt, String[] inlineParameters,  Object parameter) throws SQLException {
		try {
			if(parameter!=null && inlineParameters.length>0) {
				if(parameter.getClass().isPrimitive() || CharSequence.class.isAssignableFrom(parameter.getClass())) {
					pstmt.setObject(1, parameter);
				}else {
					for(int i=0; i<inlineParameters.length; i++) {
						Object value = findValue(inlineParameters[i], parameter);
						pstmt.setObject(i+1, value);
					}
				}
			}
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] columnNames = new String[rsmd.getColumnCount()];
			for(int i=0; i<columnNames.length; i++) {
				columnNames[i] = rsmd.getColumnName(i+1).toLowerCase();
			}
			List<T> list = new ArrayList<>();
			while(rs.next()) {
					T vo = resultClass.newInstance();
					list.add(vo);
					setProperties(vo, columnNames, rs);
			}
			return list;
		}catch (Exception e) {
			throw new SQLException(e);
		}
	}

	private Object findValue(String name, Object parameter) throws Exception{
		PropertyDescriptor pd = new PropertyDescriptor(name, parameter.getClass());
		return pd.getReadMethod().invoke(parameter);
	}

	private void setProperties(T vo, String[] columnNames, ResultSet rs) {
		for(String colName : columnNames) {
			try {
				Field field = resultClass.getDeclaredField(colName);
				ITypeHandler typeHandler = findTypeHandler(field.getType());
				typeHandler.setProperty(colName, vo, rs);
			}catch (Exception e) {
				continue;
			}
		}
	}
	
	

}
