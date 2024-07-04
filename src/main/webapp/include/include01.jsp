<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
	
%>

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인크루드 01</title>
</head>
<body> -->
	<div>
		<h1>이름은 <%=name %>입니다.</h1>
		<h2>이미지 파일이름: <%=imgName %></h2>
	</div>
<!-- </body>
</html> -->