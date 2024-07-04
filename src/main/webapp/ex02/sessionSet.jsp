<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "홍길동");
	session.setAttribute("id", "hong");
	
	application.setAttribute("address", "부산");
	String address = (String) application.getAttribute("address");
	
	//HttpSession mysession = request.getSession();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 데이터 바인딩: set</title>
</head>
<body>
	<h1>내장 객체 session 데이터 바인딩: set</h1>
	<hr>
	<h3>생성된 세션 ID: <%=session.getId() %></h3>
	<h3>application(ServletContext): <%=application %></h3>
	<a href="/webjsp/ex02/sessionGet.jsp">세션값 읽기</a>
</body>
</html>