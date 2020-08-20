package kr.or.ddit.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.example.vo.CollectionDIVO;

public class CollectionDIContainerTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = 
				new GenericXmlApplicationContext("classpath:kr/or/ddit/example/conf/CollectionDI-container.xml");
		CollectionDIVO vo1 = container.getBean("vo2", CollectionDIVO.class);
		System.out.println(vo1.getList());
		System.out.println(vo1.getSet());
		System.out.println(vo1.getMap());
		System.out.println(vo1.getProps());
		System.out.println(vo1.getArray());
		String[] names = container.getBeanDefinitionNames();
		names = container.getBeanNamesForType(String[].class);
		for(String beanName : names) {
			System.out.println(beanName);
		}
	}
}














