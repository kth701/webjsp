<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--  taglib디렉티브   -->
<%
	String address = "부산";
	String ctxPath = request.getContextPath();
%>
<!--  변수  -->
<c:set var="id" 	value="hong" scope="page" />
<c:set var="name" 	value="홍길동" scope="page" />
<c:set var="address" value="<%=address%>" scope="page" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 표준 태그 라이브러리</title>
</head>
<body>
	<h1>JSTL 표준 태그 라이브러리</h1>
	<hr>
	<div>

	</div>
	<div>
		아이디: ${id}<br>
		이름: ${name }<br>
		주소: ${address } <%=address %>
		<hr>
		객체 해재후<br>
		<c:remove var="address"/>
		주소: ${address }
		<hr>
		contextPath : ${contextPath } or  <%=ctxPath %>
	</div>
</body>
</html>

<%-- 
JSTL : 스크립틀릿을 사용하지 않고 제어문, 반복문 등을 사용가능
--%>