package kr.or.ddit.example.auto.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import kr.or.ddit.example.auto.dao.IAutoDAO;
@Service
public class AutoServiceImpl1 implements IAutoService {

	private IAutoDAO dao;
	public AutoServiceImpl1(){}
//	@Resource(name = "autoDAO_oracle")
//	@Autowired
	@Inject
	@Required
	public void setDao(IAutoDAO dao) {
		this.dao = dao;
	}
	public AutoServiceImpl1(IAutoDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String readInfo() {
		return dao.getRawData();
	}

}
