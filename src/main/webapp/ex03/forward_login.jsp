
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String) request.getParameter("user_id");
String pw = (String) request.getParameter("user_pw");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward_login</title>
</head>
<body>
	<h1>포워딩 페이지 입니다.</h1>
	
	<hr>
	<h1>환영합니다. <%= id %> 님 , pw=<%=pw %></h1>
</body>
</html>