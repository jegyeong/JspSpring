package kr.or.ddit.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.example.service.ISampleService;

public class AopContextTestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/example/conf/aop-context.xml");
		context.registerShutdownHook();
		
		ISampleService service = context.getBean(ISampleService.class);
		System.out.println(service.readInformation());
	}
}
