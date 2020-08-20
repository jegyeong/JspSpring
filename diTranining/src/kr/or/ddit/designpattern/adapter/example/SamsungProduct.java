package kr.or.ddit.designpattern.adapter.example;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungProduct implements PluggableKST {

	@Override
	public void receiveElectricWithTwoLeg() {
		System.out.println("이핀짜리 삼성 제품");
	}

}
