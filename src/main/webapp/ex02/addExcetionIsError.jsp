<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  errorPage="add_exception_process.jsp" %>

<%
	// errorPage="add_exception_process.jsp" 
	// 예외 발생시 예외 처리할 JSP페이지 설정
	int num = Integer.parseInt(request.getParameter("num")  );
	
	int sum = 0;
	for (int i=1; i<=num; i++){
		sum += i;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addExcetionIsError 페이지</title>
</head>
<body>
	<h2>계산 결과 : <%= sum %></h2>
</body>
</html>