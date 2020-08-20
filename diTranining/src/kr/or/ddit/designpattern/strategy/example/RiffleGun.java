package kr.or.ddit.designpattern.strategy.example;

import org.springframework.stereotype.Component;

@Component
public class RiffleGun implements Gun {

	@Override
	public void shot() {
		System.out.println("라이플총으로 빠르게 쏴!");
	}

}
