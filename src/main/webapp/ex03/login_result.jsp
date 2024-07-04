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
<title>login_result.jsp</title>
</head>
<body>
<%
/* 	RequestDispatcher dispacher = request.getRequestDispatcher("forward_login.jsp");
	dispacher.forward(request, response); 
*/
%>

<jsp:forward page="forward_login.jsp" />

	<h1>환영합니다. <%= id %>님</h1>
</body>
</html>