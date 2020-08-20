package kr.or.ddit.designpattern.templtemethod.example2.inlineparameter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.ITypeHandler;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.IntegerTypeHandler;
import kr.or.ddit.designpattern.templtemethod.example2.typehandler.StringTypeHandler;

public abstract class ExecuteQueryTemplateVersion2<T> {
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
	
	private String[] parseQuery(String queryWithParams, StringBuffer sql) {
		List<String> inlineParameters = new ArrayList<>();
		Pattern regex = Pattern.compile("#\\{([\\w_]+)\\}");
		Matcher matcher = regex.matcher(queryWithParams);
		while(matcher.find()) {
			inlineParameters.add(matcher.group(1));
			matcher.appendReplacement(sql, "?");
		}
		matcher.appendTail(sql);
		return inlineParameters.toArray(new String[inlineParameters.size()]);
	}
	
	public List<T> queryForList(String query, Object parameter){
		StringBuffer sql = new StringBuffer();
		String[] inlineParameters = parseQuery(query, sql);
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			List<T> list = executeQuery(pstmt, inlineParameters, parameter);
			return list;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public T queryForObject(String query, Object parameter){
		List<T> list = queryForList(query, parameter);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	
	protected abstract List<T> executeQuery(PreparedStatement pstmt, String[] inlineParameters, Object parameter) throws SQLException;
}










