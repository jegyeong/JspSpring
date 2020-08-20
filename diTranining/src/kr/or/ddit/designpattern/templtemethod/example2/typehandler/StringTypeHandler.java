package kr.or.ddit.designpattern.templtemethod.example2.typehandler;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 문자 컬럼을 결과 객체의 프로퍼티에 바인드하기 위한 핸들러
 *
 */
public class StringTypeHandler implements ITypeHandler {

	@Override
	public void setProperty(String name, Object result, ResultSet rs) throws SQLException {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(name, result.getClass());
			pd.getWriteMethod().invoke(result, rs.getString(name));
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

}
