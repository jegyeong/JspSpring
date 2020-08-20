package kr.or.ddit.designpattern.templtemethod.example2.typehandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 조회된 컬럼의 타입에 따라 {@link ResultSet}의 타입별 getter 를 호출하고, name 매핑에 따라 결과 객체의  setter 를 호출하여 값을 바인드함.
 * @see IntegerTypeHandler 
 * @see StringTypeHandler
 *
 */
public interface ITypeHandler {
	public void setProperty(String name, Object result, ResultSet rs) throws SQLException;
}
