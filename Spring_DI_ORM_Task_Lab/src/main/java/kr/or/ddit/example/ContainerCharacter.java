package kr.or.ddit.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.example.dao.ISampleDAO;
import kr.or.ddit.example.dao.SampleDAOImpl;

public class ContainerCharacter {
	public static void main(String[] args) {
		ConfigurableApplicationContext container =
				new ClassPathXmlApplicationContext("kr/or/ddit/example/conf/DI-containerDesc.xml");
		container.registerShutdownHook();
		ISampleDAO dao1 = container.getBean(SampleDAOImpl.class);
		ISampleDAO dao2 = container.getBean(SampleDAOImpl.class);
		System.out.println(dao1 == dao2);
		container.close();
		System.exit(1);
	}
}










