<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 같은 브라우저내에서만 정보 공유
	session.setAttribute("name", "홍길동");
	session.setAttribute("id", "hong");
	
	// 컨텍스트 범위내에서 정보 공유
	application.setAttribute("address", "부산");
	String address = (String) application.getAttribute("address");
	
	// 요청관계에서만 정보를 공유(포워딩 방식에만 적용)
	request.setAttribute("age", "10");
	String age = (String) request.getAttribute("age");
	
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
	<h3>생성된 세션 값: <%=session.getAttribute("name") %>, 
		<%=session.getAttribute("id") %>
	</h3>
	
	<h3>sendRedirect방식 (클라이언트에 접속하는 방식)</h3>
	<a href="/webjsp/ex02/sessionGet.jsp">세션값 읽기</a>
	<hr>
	
	<h3>application(ServletContext): <%=address %></h3>
	<h3>request(ServletRequest): <%= age %></h3>
	
	<h3>RequestDispatcher방식 (포워딩:서버에서 페이지연결하는 방식)</h3>
	<%
 	RequestDispatcher dispatch = request.getRequestDispatcher("sessionGet.jsp");
	dispatch.forward(request, response); 
	%>
	
</body>
</html>