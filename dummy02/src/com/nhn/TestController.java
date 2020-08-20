package com.nhn;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.stereotype.CommandHandler;
import kr.or.ddit.mvc.stereotype.URIMapping;

@CommandHandler
public class TestController {
	@URIMapping("/sample.nhn")
	public String sample(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("today", new Date());
		
		return "sampleView";
	}
}








