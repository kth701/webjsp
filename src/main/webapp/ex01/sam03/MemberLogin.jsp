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
	}
</style>

</head>
<body>
<div class="container ">
	<div class="login" >
		<h3>회원 가입</h3>
		<hr>
		<form action="/webjsp/registerMember" method="post" name="frmMember">
			<div>
				<label>아이디:</label>
				<input type="text" name="user_id" class="form-control">
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="password" name="user_pw" class="form-control">
			</div>
			<div>
				<label>이름:</label>
				<input type="text" name="user_name" class="form-control">
			</div>
			<div>
				<label>이메일:</label>
				<input type="text" name="user_email" class="form-control">
			</div>
			
			<br >
			
			<!--  controller에서 작업(url)구분 역할 -->
			<input type="hidden" name="command" value="addMember">
			
			<div class="d-flex justify-content-center loginBtn">
				<!-- <div><input type="submit" 	value="가입하기" 		class="btn btn-success"></div> -->

				<div><input type="button" 	value="가입하기"  	onClick="fn_sendMember()" class="btn btn-success"></div>
				<div><input type="reset" 	value="다시입력" 	class="btn btn-danger"></div>
				<div><input type="button" 	value="목록"  		onClick="fn_listMember()" class="btn btn-warning mx-1"></div>
			</div>
		</form>
	</div>

</div>	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script type="text/javascript">

 function fn_sendMember(){
	
	
	var frmMember = document.frmMember;
	
	// 각항목을 체크 한후
	
	// 정상이면 처리
	frmMember.method = "post";
	frmMember.action ="/webjsp/member/addMember.do";
	frmMember.submit();
	
}
	
function fn_listMember(){
	location.href = "/webjsp/member/listMember.do";
} 
</script>
</body>
</html>

