<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라언트 로그인 View Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
<div class="container ">
	<div class="login" >
		<h3>javascript 로그인 </h3>
		<hr>
		<form name="frmLogin" action="/webjsp/login3" method="get" >
			<div>
				<label>아이디:</label>
				<input type="text" name="user_id" class="form-control">
			</div>
			<div>
				<label>패스워드:</label>
				<input type="password" name="user_pw" class="form-control">
			</div>
			
			<br >

			<div class="d-flex justify-content-center">
				<div><input type="button" onClick="fn_validate()" 	value="로그인" 		class="btn btn-success"></div>
				<div><input type="reset" 	value="다시입력" 	class="btn btn-danger" ></div>
				<div><input type="hidden" 	name="user_address" value="부산시"></div>
			</div>
			
		</form>
	</div>
</div>	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script type="text/javascript">

function fn_validate(){
	//	보내기 전에 값을 체크한후 이상없으면 서버에 전송
	var frmLogin = document.frmLogin;
	var user_id = frmLogin.user_id.value;
	var user_pw = frmLogin.user_pw.value;
	
	if ((user_id.length==0 || user_id=="") || (user_pw.length == 0 || user_pw == "")){
		alert("아이디와 비빌번호는 필수")
	}else{
		frmLogin.method = "post";
		frmLogin.action= "/webjsp/login3";
		frmLogin.submit();
	}
}

</script>
</body>
</html>