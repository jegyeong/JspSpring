package kr.or.ddit.designpattern.strategy.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.designpattern.adapter.example.conf.AdapterPatternContainerConfig;

public class SolidierTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent =
				new AnnotationConfigApplicationContext(AdapterPatternContainerConfig.class);
		
		ConfigurableApplicationContext child =
				new ClassPathXmlApplicationContext(new String[] {"kr/or/ddit/designpattern/strategy/example/conf/strategy-context.xml"}, parent);
		child.registerShutdownHook();
//		Gun gun = context.getBean("biBitan", Gun.class);
		Solidier solidier1 = child.getBean(Solidier.class);
		Solidier solidier2 = child.getBean(Solidier.class);
		Solidier solidier3 = child.getBean(Solidier.class);
		Solidier solidier4 = child.getBean(Solidier.class);
		Solidier solidier5 = child.getBean(Solidier.class);
		
//		solidier1.armedWithGun(gun);
		solidier1.attack();
		System.out.println(solidier1.getXiaomi());
	}
}











