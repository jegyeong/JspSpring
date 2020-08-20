package kr.or.ddit.designpattern.templtemethod;

public abstract class TemplateClass {
	public final void template() {
		stepOne();
		stepTwo();
		stepThree();
	}
	private void stepOne() {
		System.out.println("첫번째 단계");
	}
	protected abstract void stepTwo();
	private void stepThree() {
		System.out.println("세번째 단계");
	}
}
