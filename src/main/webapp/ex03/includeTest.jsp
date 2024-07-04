<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!--  반복되는 영역을 include  -->
	<%@include file="/include/bootstrap_include.jsp" %>

</head>
<body>
	<div class="container">
		<h1>인크루드 테스트</h1>
		<hr>
	
		안녕하세요.  쇼핑몰 중심 JSP시작 부분
		<div>
			<jsp:include page="/include/include01.jsp"  flush="true">
				<jsp:param name="name" 		value="동길이"/>
				<jsp:param name="imgName" 	value="사과"/>
			</jsp:include>
		</div>
		안녕하세요.  쇼핑몰 중심 JSP끝부분
		
	</div>
</body>
</html>

<%--
JSP 액션 태그 : 자코드 대신 사용



인크루드 액션 태그: <jsp:include> 	: 이미 있는 JSP를 현재JSP에 포함하는 태그
포워드 액션 태그 : <jsp:forword>	: 서블리 RequestDispatcher클래스의 포워딩 기능
유즈빈 액션 태그 : <jsp:useBean> 	: 객체를 생성하기 위한 new 연산자 기능
셋프로퍼티 액션 태그: <jsp:setProperty> : setter를 대신 하는 기능
겟프로퍼티 액션 태그: <jsp:getProperty> : getter를 대신 하는 기능



 --%>