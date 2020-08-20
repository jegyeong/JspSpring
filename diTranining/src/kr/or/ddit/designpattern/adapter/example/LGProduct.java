package kr.or.ddit.designpattern.adapter.example;

import org.springframework.stereotype.Component;

@Component("LG")
public class LGProduct implements PluggableKST {

	@Override
	public void receiveElectricWithTwoLeg() {
		System.out.println("이핀짜리 LG 제품");
	}

}
