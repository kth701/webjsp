<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 데이터 바인딩: Get</title>
</head>
<body>
	<h1>내장 객체 session 데이터 바인딩: Get</h1>
	<hr>
	<div>
	세션 값 읽기 : 생성된 세션 ID: <%=session.getId() %>
	<hr>
	이름: <%= name %><br>
	아이디: <%= id %>
	</div>
	<% session.invalidate();  %>
	<a href="/webjsp/ex02/sessionInvalidate.jsp">세션값 삭제후</a>

</body>
</html>