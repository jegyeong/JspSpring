<%@page import="java.util.Arrays"%>
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
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	th,td {
		border:1px solid black;
	}
</style>
</head>
<body>
<!-- 전송 파라미터의 처리자 -->
<!-- 이름(name), 생년월일(birthday), 나이(age), 학력(grade),  -->
<!-- 성별(gen), 자격증(license), 경력사항(career) -->
<%
	Map<String, String> nameMap = new LinkedHashMap<String, String>();
	nameMap.put("name", "이름");
	nameMap.put("birthday", "새일");
	nameMap.put("age", "나이");
	nameMap.put("grade", "학력");
	nameMap.put("gen", "성별");
	nameMap.put("license", "자격증");
	nameMap.put("career", "경력사항");
%>
<table>
	<thead>
		<tr>
			<th>파라미터명</th>
			<th>파라미터값</th>
		</tr>
	</thead>
	<tbody>
		<%
			request.setCharacterEncoding("UTF-8");
			Map<String, String[]> parameterMap = request.getParameterMap();
			for(Entry<String, String[]> entry : parameterMap.entrySet()){
				String paramName = entry.getKey();
				String[] values = entry.getValue();
				%>
				<tr>
					<td><%=paramName %></td>
					<td><%=Arrays.toString(values) %></td>
				</tr>
				<%
			}
		%>
	</tbody>
</table>
</body>
</html>











