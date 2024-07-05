<%@page import="ex03.vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	String name = request.getParameter("user_name");
	String email = request.getParameter("user_email");
	
	System.out.println(id);
	
	/* MemberBean member1 = new MemberBean();
	member1.setId(id); 
	member1.getId(); */
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 학습하기</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>

	<jsp:useBean id="member" class="ex03.vo.MemberBean" scope="page" /> 	
	<jsp:setProperty property="id" 		name="member" value="<%= id %>" />
	<jsp:setProperty property="pwd" 	name="member" value="<%= pw %>" />
	<jsp:setProperty property="name" 	name="member" value="<%= name %>" />
	<jsp:setProperty property="email" 	name="member" value="<%= email %>"/> 
	
	<%-- 
		전송된 매개변수 이름과 빈 속성이름이 동일한 경우 자동으로 설정
		<jsp:setProperty property="*" name="member"/>
	 --%>
	
	<div class="container">
		<h1>useBean 테스트</h1><hr>
		<hr>
		<div>
			<jsp:getProperty property="id" 			name="member"/>
			<jsp:getProperty property="pwd" 		name="member"/>
			<jsp:getProperty property="name" 		name="member"/>
			<jsp:getProperty property="email" 		name="member"/>
			<hr>
			<%=member.getId() %>
		</div>
	</div>
</body>
</html>