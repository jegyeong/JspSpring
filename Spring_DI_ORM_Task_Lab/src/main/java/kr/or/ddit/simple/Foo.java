package kr.or.ddit.simple;

public class Foo {
//	1. 의존 객체를 직접 생성 : 결합력 최상
//	IBar bar = new Bar();
//	IBaz baz = new Baz();
//	2. Factory pattern 
//	IBar bar = ObjectFactory.getBar();
//	IBaz baz = ObjectFactory.getBaz();
//	3. Strategy Pattern
	private IBar bar;
	private IBaz baz;
	public Foo(IBar bar, IBaz baz) {
		super();
		this.bar = bar;
		this.baz = baz;
	}
	
}
