package kr.or.ddit.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIContainerExample {
	public static void main(String[] args) {
		ApplicationContext container = 
				new ClassPathXmlApplicationContext("kr/or/ddit/simple/conf/simple-di.xml");
		Foo foo = container.getBean("foo1", Foo.class);
		System.out.println(foo);
		IBar bar = (IBar) container.getBean("bar");
	}
}
