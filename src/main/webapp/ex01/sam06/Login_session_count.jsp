<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
	.loginBtn {
		gap: 0.5em;
		margin: 5px;
	}
</style>

</head>
<body>
<div class="container ">
	<div class="login" >
		<h3>회원 가입</h3>
		<hr>
		<form action="/webjsp/login_session_count" method="post" name="frmMember">
			<div>
				<label>아이디:</label>
				<input type="text" name="user_id" class="form-control">
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="password" name="user_pw" class="form-control">
			</div>

			<div class="d-flex justify-content-center loginBtn">
				<div><input type="submit" 	value="가입하기"  	class="btn btn-success"></div>
				<div><input type="reset" 	value="다시입력" 	class="btn btn-danger"></div>
			</div>
		</form>
	</div>

</div>	
	

</body>
</html>