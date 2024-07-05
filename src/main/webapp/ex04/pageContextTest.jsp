<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext기능</title>
</head>
<body>
	<h3>pageContext 기능</h3>
	<hr>
	<a  href="/webjsp/ex03/MemberForm.jsp"> 회원가입 화면 페이지 요청하기</a>
	<div>Context Path : <%= contextPath %></div>
	<a  href="<%=contextPath %>/ex03/MemberForm.jsp"> 회원가입 화면 페이지 요청하기</a>
</body>
</html>