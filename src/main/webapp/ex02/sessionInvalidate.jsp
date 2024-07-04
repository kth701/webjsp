<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
	
	String address = (String) application.getAttribute("address");
	String age = (String) request.getAttribute("age");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 데이터 바인딩 삭제: Invalidate()</title>
</head>
<body>
	<h1>내장 객체 session 데이터 바인딩 삭제된 후 : Invalidate()</h1>
	<hr>
	<div>
	세션 값 읽기 : 생성된 세션 ID: <%=session.getId() %>
	<hr>
	이름: <%= name %><br>
	아이디: <%= id %>
	</div>
	
	<div>
		<h3>application(ServletContext): <%=address %></h3>
	</div>
	<h3>request(ServletRequest): <%= age %></h3>
	


</body>
</html>