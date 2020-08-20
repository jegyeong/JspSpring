<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
	Http : Connectionless/Stateless : 비연결지향 무상태 특성
	해당 단점을 보완하는 방법 : session, cookie
	Cookie : 대화 유지를 위한 상태 정보를 클라이언트 쪽에 저장하는 개념.
	1. 쿠키 생성
	2. 응답과 함께 클라이언트로 전송
	
	3. 브라우저별 쿠키 저장소에 각기 따로 저장.
	4. 다음 요청이 발생할때 함께 서버로 재전송.
	
	5. 요청에 포함된 쿠키를 통해 상태 복원.
	
	*** 쿠키의 속성
	1. name
	2. value : 문자열만 가능, 특수문자가 포함된다면, URL encoding 방식으로 인코딩 필요.
	3. domain/host : 쿠키를 다음 요청에 재전송시킬때 포함 여부를 결정. 
			만약, host name 을 생략하면, 해당 기관의 모든 서버를 대상으로 쿠키 재전송.
		www.naver.com - GTLD(Global Top Level Domain) 
		www.naver.co.kr - NTLD(National Top Level Domain)
		email.naver.com
		blog.naver.com
	<%
// 		Cookie tmpCookie = new Cookie("firstCookie", "FirstCookie");
// 		response.addCookie(tmpCookie);
// 		String cookieValue = URLEncoder.encode("한글 국산 쿠키", "UTF-8");
// 		Cookie koreanCookie = new Cookie("koreanCookie", cookieValue);
// 		response.addCookie(koreanCookie);
		
		Cookie allDomainCookie = new Cookie("allDomainCookie", "ALL~~Domain~~");
		allDomainCookie.setDomain(".chy.com");
		response.addCookie(allDomainCookie);

		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie tmp : cookies){
				String name = tmp.getName();
				String value = URLDecoder.decode(tmp.getValue(), "UTF-8");
				out.println(
					String.format("%s : %s", name, value)
				);
			}
		}
	%>
</pre>
</body>
</html>










