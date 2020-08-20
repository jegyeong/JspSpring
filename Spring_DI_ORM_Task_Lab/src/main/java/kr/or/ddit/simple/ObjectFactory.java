package kr.or.ddit.simple;

public class ObjectFactory {
	public static IBar getBar() {
		return new Bar();
	}
	public static IBaz getBaz() {
		return new Baz();
	}
}
