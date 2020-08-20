package kr.or.ddit.designpattern.strategy;

public class Context {
	private Sort strategy;
	public void setStrategy(Sort strategy) {
		this.strategy = strategy;
	}
	
	public void operation() {
		strategy.algorithm();
	}
}	
