<%@ page language="java" contentType="text/html; charset=UTF-8"
	
    pageEncoding="UTF-8"%>
<%
	String address = (String)request.getAttribute("address");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_request_result</title>
</head>
<body>
	<h3>/ex04/el_request_result.jsp에서 매개변수에 값전달 후 결과값</h3>
	<hr>
	아이디 : ${param.user_id }<br>
	비밀번호: ${pawram.user_pw }<br>
	이름: ${param.user_name }<br>
	이메일: ${param.user_email }<br>
	<hr>
	<h3>EL 포워딩 : EL_forword.jsp에서 포워딩 후 정보공유 결과</h3>
	주소: ${requestScope.address } / <%=address %>
	<hr>
	<h3>EL 포워딩 : EL_Collection_forword.jsp에서 포워딩 후 정보공유 결과</h3>
	<div>
		${memberList[0]}<br>
		${memberList[0].id },${memberList[0].name }
	</div>
	<div>
		${memberList[1]}<br>
		${memberList[1].id}, ${memberList[1].name}
	</div>
	<hr>
	<h3>스코프 우선 순위</h3>
	page > request > session > application<br>
	${age}
	

</body>
</html>