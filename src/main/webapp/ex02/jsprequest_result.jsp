<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	
	String gender = request.getParameter("gender");
	String gender_name = gender.equals("male") ?"남자":"여자";
	
	String[] hobby = request.getParameterValues("hobby");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Result Page</title>
</head>
<body>
	<h1> Request Result Page</h1>
	<hr>
	<div> 이름: <%=name %> 	</div>
	<div> 성별: <%= gender_name %></div>
	<div>
		취미<hr>
		<% for( int i=0; i<hobby.length; i++){ %>
			<!-- html영역에 값을 출력 -->
			<div><%=hobby[i] %></div>
			
		<%	}	%>
	</div>
	
</body>
</html>