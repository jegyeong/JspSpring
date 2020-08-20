package kr.or.ddit.example;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import kr.or.ddit.example.controller.SampleController;

public class DIContainerDescTest {
	public static void main(String[] args) throws IOException {
		ApplicationContext container = 
				new GenericXmlApplicationContext(new ClassPathResource("kr/or/ddit/example/conf/DI-containerDesc.xml"));
		SampleController controller = container.getBean("sampleController1", SampleController.class);
		System.out.println(controller.commandProcess());
		
//		resource loading
//		new File( DIContainerDescTest.class.getResource("/log4j2.xml").getFile() );
		Resource log4j2 = new ClassPathResource("log4j2.xml");
		log4j2 = container.getResource("classpath:log4j2.xml");
		System.out.println(log4j2.contentLength());
//		new File("d:/lombok-1.18.12.jar");
		Resource lombok = new FileSystemResource("d:/lombok-1.18.12.jar");
		lombok = container.getResource("file:d:/lombok-1.18.12.jar");
		System.out.println(lombok.contentLength());
	}
}











