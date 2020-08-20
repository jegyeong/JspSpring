package kr.or.ddit.designpattern.templtemethod.example2;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.designpattern.templtemethod.example2.typehandler.ITypeHandler;

public class GeneralDAOExecuteQuery<T> extends ExecuteQueryTemplate<T> {
	
	private Class<T> resultClass;
	public GeneralDAOExecuteQuery(Class<T> resultClass) {
		this.resultClass = resultClass;
	}
	
	@Override
	protected List<T> executeQuery(PreparedStatement pstmt, Object[] parameters) throws SQLException {
		for(int i=0; i<parameters.length; i++) {
			pstmt.setObject(i+1, parameters[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		String[] columnNames = new String[rsmd.getColumnCount()];
		for(int i=0; i<columnNames.length; i++) {
			columnNames[i] = rsmd.getColumnName(i+1).toLowerCase();
		}
		List<T> list = new ArrayList<>();
		while(rs.next()) {
			try {
				T vo = resultClass.newInstance();
				list.add(vo);
				setProperties(vo, columnNames, rs);
			}catch (Exception e) {
				throw new SQLException(e);
			}
		}
		return list;
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
