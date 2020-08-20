package kr.or.ddit.designpattern.templtemethod.example2.typehandler;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 숫자(정수) 컬럼의 값을 결과 객체에 프로퍼티에 바인드하기 위한 핸들러
 *
 */
public class IntegerTypeHandler implements ITypeHandler {

	@Override
	public void setProperty(String name, Object result, ResultSet rs) throws SQLException {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(name, result.getClass());
			pd.getWriteMethod().invoke(result, rs.getInt(name));
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

}
