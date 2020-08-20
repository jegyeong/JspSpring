package kr.or.ddit.designpattern.strategy.example;

public class ShotGun implements Gun {

	@Override
	public void shot() {
		System.out.println("샷건으로 묵직하게 쏴!");
	}

}
