package kr.or.ddit.example.auto;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.example.auto.service.IAutoService;

public class AutoDIContainerTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new
				GenericXmlApplicationContext("classpath:kr/or/ddit/example/conf/autoDI-container.xml");
		IAutoService service = container.getBean(IAutoService.class);
		System.out.println(service.readInfo());
	}
}
