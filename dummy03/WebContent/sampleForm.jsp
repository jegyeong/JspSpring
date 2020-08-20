<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이름(name), 생년월일(birthday), 나이(age), 학력(grade), 성별(gen), 자격증(license), 경력사항(career) -->
<%
	Map<String, String> gradeMap = new LinkedHashMap<String, String>();
	Map<String, String> licenseMap = new LinkedHashMap<String, String>();
	gradeMap.put("G001", "고졸");
	gradeMap.put("G002", "대재");
	gradeMap.put("G003", "초대졸");
	gradeMap.put("G004", "대졸");
	gradeMap.put("G005", "석사");
	gradeMap.put("G006", "박사");
	licenseMap.put("L001", "정보처리기사");
	licenseMap.put("L002", "정보보안기사");
	licenseMap.put("L003", "SQLD");
	licenseMap.put("L004", "SQLP");
	
%>
<form action="sampleProcess.jsp" method="get">
<pre>
	이름 : <input type="text" name="name" />
	생일 : <input type="date" name="birthday" />
	나이 : <input type="number" name="age" />
	학력 : <select name="grade">
			<option value>학력</option>
			<%
				for( Entry<String, String> entry : gradeMap.entrySet()){
					%>
						<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
					<%
				}
			%>
		 </select>
	성별 :<label><input type="radio" name="gen" value="F">여자</label>
		 <label><input type="radio" name="gen" value="M">남자</label>	 
	자격증 : 
		<select name="license" multiple>
			<%
				Iterator<String> keys = licenseMap.keySet().iterator();
				while(keys.hasNext()){
					String code = keys.next();
					String name = licenseMap.get(code);
					%>
					<option value="<%=code %>"><%=name %></option>
					<%
				}
			%>
		</select>
	경력사항 : 
		<textarea name="career" rows="5" cols="50"></textarea>
	<button type="submit">등록</button>			 
	<button type="reset">취소</button>			 
	<button type="button">걍버튼</button>			 
</pre>	
</form>
</body>
</html>














