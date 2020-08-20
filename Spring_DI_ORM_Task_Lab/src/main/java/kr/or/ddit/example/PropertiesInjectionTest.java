package kr.or.ddit.example;

import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.example.vo.DbInfoVO;

public class PropertiesInjectionTest {
	public static void main(String[] args) {
		Properties systemProps = System.getProperties();
		for(Entry<Object, Object> entry : systemProps.entrySet()) {
			System.out.printf("%s : %s \n", entry.getKey(), entry.getValue());
		}
		
		ConfigurableApplicationContext container =
				new ClassPathXmlApplicationContext("kr/or/ddit/example/conf/Properties-injection.xml");
		container.registerShutdownHook();
		DbInfoVO vo1 = container.getBean("vo1", DbInfoVO.class);
		DbInfoVO vo2 = container.getBean("vo2", DbInfoVO.class);
		System.out.println(vo1);
		System.out.println(vo2);
	}
}








