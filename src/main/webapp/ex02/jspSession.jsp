<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//HttpSession session = request.getSession();
	session.setMaxInactiveInterval(5);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP session </title>
</head>
<body>
	<h1> session 테스트</h1>
	<div>
		isNew() : <%= session.isNew() %><br>
		생성시간: <%=session.getCreationTime() %><br>
		최종 접속 시간: <%= session.getLastAccessedTime() %><br>
		세션 ID: <%= session.getId() %><br>
		세션 유효 기간: <%= session.getMaxInactiveInterval() %>
	</div>
</body>
</html>