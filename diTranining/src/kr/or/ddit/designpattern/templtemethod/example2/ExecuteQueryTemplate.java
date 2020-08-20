package kr.or.ddit.designpattern.templtemethod.example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.ITypeHandler;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.IntegerTypeHandler;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.StringTypeHandler;

public abstract class ExecuteQueryTemplate<T> {
	private static Map<Class<?>, ITypeHandler> typeHandlers = new LinkedHashMap<>();
	static {
		typeHandlers.put(Integer.class, new IntegerTypeHandler());
		typeHandlers.put(String.class, new StringTypeHandler());
	}
	public ITypeHandler findTypeHandler(Class<?> propertyType) {
		ITypeHandler typeHandler = typeHandlers.get(propertyType);
		if(typeHandler==null) typeHandler = typeHandlers.get(String.class);
		return typeHandler;
	}
	
	public List<T> queryForList(String query, Object[] parameters){
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);	
		){
			List<T> list = executeQuery(pstmt, parameters);
			return list;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public T queryForObject(String query, Object[] parameters){
		List<T> list = queryForList(query, parameters);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	
	protected abstract List<T> executeQuery(PreparedStatement pstmt, Object[] parameters) throws SQLException;
}










