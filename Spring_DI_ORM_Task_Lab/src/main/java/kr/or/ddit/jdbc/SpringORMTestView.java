package kr.or.ddit.jdbc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.vo.MemberVO;

public class SpringORMTestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/jdbc/conf/*-context.xml");
		
		IMemberDAO dao = context.getBean(IMemberDAO.class);
		System.out.println(dao.getClass().getName());
		MemberVO member = dao.selectMember("a001");
		System.out.println(member);
	}
}
