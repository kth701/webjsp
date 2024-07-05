<%@page import="java.util.ArrayList"%>
<%@page import="ex03.vo.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

List<MemberBean> memberList = new ArrayList();
MemberBean m1 = MemberBean.builder()
					.id("Lee").pwd("1234").name("홍길동").email("Lee@gamiel.com")
					.build();
MemberBean m2 = MemberBean.builder()
					.id("Lee2").pwd("1234").name("홍길동2").email("Lee2@gamiel.com")
					.build();
memberList.add(m1);
memberList.add(m2);

request.setAttribute("memberList", memberList);

// Scope의 우선순위: page > request > session > application
request.setAttribute("age", 10);
session.setAttribute("age", 20);
application.setAttribute("age", 30);

pageContext.setAttribute("age", 40);// 페이지를 벗어나면 소멸


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 포워딩: 서버에 웹페이지 연동(Collection)</title>
</head>
<body>
	<h1>EL 포워딩 테스트(Collection)</h1>
	<hr>
	<h3>같은 페이지 내에서 스코프 우선 순위</h3>
	page > request > session > application<br>
	<%-- ${age } --%>
	<hr>
	<jsp:forward page="el_request_result.jsp" />
	
	
</body>
</html>