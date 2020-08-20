package kr.or.ddit.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SampleDAOImpl implements ISampleDAO {
	public SampleDAOImpl() {
		System.out.println(getClass().getSimpleName()+" 객체 생성");
	}
	
	public void init() {
		System.out.println(getClass().getSimpleName()+" 객체 초기화");
	}
	public void destroy() {
		System.out.println(getClass().getSimpleName()+" 객체 소멸");
	}
	
	@Override
	public String selectRawData() {
		return "오라클에서 조회된 데이터";
	}

}
