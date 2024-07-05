<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@include file="/include/bootstrap_include.jsp" %>

</head>
<body>

	<div class="container">
		<!-- <form action="memberRegister.jsp" method="get"> -->
		<form action="/webjsp/ex04/el_request_result.jsp" method="get">
				아이디: 
				<input type="text" 		name="user_id" class="form-control"><br>
				비밀번호: 
				<input type="password" 	name="user_pw" class="form-control"><br>
				이름: 
				<input type="text" 	name="user_name" class="form-control"><br>
				이메일: 
				<input type="text" 	name="user_email" class="form-control"><br>
				<div>
					<input type="submit" value="로그인" class="btn btn-success">
					<input type="reset" value ="다시입력" class="btn btn-danger">
				</div>			
		</form>
	</div>

</body>
</html>