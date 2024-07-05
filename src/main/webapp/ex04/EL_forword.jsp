<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
request.setAttribute("address", "부산");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 포워딩: 서버에 웹페이지 연동</title>
</head>
<body>
	<h1>EL 포워딩 테스트</h1>
	<hr>
	<jsp:forward page="el_request_result.jsp"></jsp:forward>
	
	
</body>
</html>