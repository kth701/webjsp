<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Enumeration enu = request.getHeaderNames();
	// 출력대상 console
	/*
	while(enu.hasMoreElements()){
		String headerName = (String) enu.nextElement();
		
		System.out.println("----");
		System.out.println(headerName);
		System.out.println(request.getHeader(headerName));
	}*/
%>   
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTTP헤더 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>HTTP 헤더 정보</h1>
		<div>
			<table class="table table-bordered">
			<%
			while(enu.hasMoreElements()){
				String headerName = (String) enu.nextElement(); %>
				
				<tr>
					<td><%=headerName %></td>
					<td><%=request.getHeader(headerName) %></td>
				</tr>
				
			<% }	%>
			</table>
		</div>
	</div>

</body>
</html>