package kr.or.ddit.simple.service;

import org.springframework.stereotype.Service;

import kr.or.ddit.simple.vo.SimpleVO;

@Service
public class SimpleService {
	
	public void plus(SimpleVO simple) {
		int leftOp = simple.getLeftOp();
		int rightOp = simple.getRightOp();
		int result = (int) simple.getOperator().operate(simple.getLeftOp(), simple.getRightOp());
		simple.setResult(result);
	}
}
