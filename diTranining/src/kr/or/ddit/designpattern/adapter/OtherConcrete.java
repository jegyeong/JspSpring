package kr.or.ddit.designpattern.adapter;

public class OtherConcrete implements Target {

	@Override
	public void request() {
		System.out.println("Target의 직접적인 구현체");
	}

}
