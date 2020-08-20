package kr.or.ddit.example.auto.dao;

public class AutoDAO_mysql implements IAutoDAO {

	@Override
	public String getRawData() {
		return "mysql 에서 조회된 데이터";
	}

}
