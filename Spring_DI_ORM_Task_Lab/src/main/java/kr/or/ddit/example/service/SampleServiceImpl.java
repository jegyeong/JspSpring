package kr.or.ddit.example.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.example.dao.ISampleDAO;

// 모든 비즈니스 로직에 시스템 로그를 기록하자.
// core concern : 비즈니스 로직  --> target(readInformation)
// cross cutting concern : 시스템 로그
 
@Service
public class SampleServiceImpl implements ISampleService {

	private ISampleDAO dao;
//	1. 생성자 주입(constructor injection)
	@Inject
	public SampleServiceImpl(ISampleDAO dao) {
		super();
		this.dao = dao;
		System.out.println(getClass().getSimpleName()+" 객체 생성, 생성자 주입");
	}
	public SampleServiceImpl() {
		super();
		System.out.println(getClass().getSimpleName()+" 객체 생성");
	}
//	2. setter injection
	public void setDao(ISampleDAO dao) {
		this.dao = dao;
		System.out.println(getClass().getSimpleName()+" 에서 "+dao.getClass().getSimpleName()+"을 주입받음.setter injection");
	}

	@Override
	public String readInformation() {
		String info = dao.selectRawData()+" 를 가공함.";
		System.err.println("로직 실행중");
		return info;
	}

}







