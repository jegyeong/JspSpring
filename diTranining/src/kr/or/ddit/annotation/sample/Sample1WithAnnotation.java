package kr.or.ddit.annotation.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.annotation.stereotype.CommandHandler;
import kr.or.ddit.annotation.stereotype.SecondSingleValueAnnotation;
import kr.or.ddit.annotation.stereotype.URIMapping;
import kr.or.ddit.annotation.stereotype.URIMapping.HttpMethod;

@CommandHandler
public class Sample1WithAnnotation {
	@SecondSingleValueAnnotation("값1")
	@URIMapping(value="text1", method=HttpMethod.POST)
	public void test1() {
		
	}
	@SecondSingleValueAnnotation("값2")
	@URIMapping("/member/memberList.do")
	public String test2(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("요청 분석 : "+req);
		return "member/memberList";
	}
	
	
	
	
	
}
