package kr.or.ddit.designpattern.templtemethod.example2;

import java.beans.PropertyDescriptor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOExecuteQuery extends ExecuteQueryTemplate<MemberVO> {

	@Override
	protected List<MemberVO> executeQuery(PreparedStatement pstmt, Object[] parameters) throws SQLException {
		for(int i=0; i<parameters.length; i++) {
			pstmt.setObject(i+1, parameters[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		String[] columnNames = new String[rsmd.getColumnCount()];
		for(int i=0; i<columnNames.length; i++) {
			columnNames[i] = rsmd.getColumnName(i+1).toLowerCase();
		}
		List<MemberVO> list = new ArrayList<>();
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			list.add(vo);
			setProperties(vo, columnNames, rs);
		}
		return list;
	}

	private void setProperties(MemberVO vo, String[] columnNames, ResultSet rs) {
		for(String colName : columnNames) {
			try {
				PropertyDescriptor pd = new PropertyDescriptor(colName.toLowerCase(), vo.getClass());
				pd.getWriteMethod().invoke(vo, rs.getObject(colName));
			}catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}
	
	

}
