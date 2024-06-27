<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클리언트 로그인 View Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
<div class="container ">
	<div class="login" >
		<h3>로그인 View Page</h3>
		<hr>
		<form action="/webjsp/login" method="get">
			<div>
				<label>아이디:</label>
				<input type="text" name="user_id" class="form-control">
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="password" name="user_pw" class="form-control">
			</div>
			
			<br >
			
			<input type="checkbox" name="subject" value="java" 		checked="checked">자바
			<input type="checkbox" name="subject" value="python" 	>파이썬
			<input type="checkbox" name="subject" value="jsp" 		>JSP
			<input type="checkbox" name="subject" value="android" 	>안드로이드
			<br />
			<input type="radio" name="address" value="1">서울
			<input type="radio" name="address" value="2">부산			 
			<input type="radio" name="address" value="3">경남
			<br />
			<select name="sel_size" size="3" multiple="multiple">
				 <option value="100">100cm</option>
				 <option value="200">200cm</option>
				 <option value="300">300cm</option>
 				 <option value="400">400cm</option>
				 <option value="500">500cm</option>
			</select>
			<div class="d-flex justify-content-center">
				<div><input type="submit" 	value="로그인" 		class="btn btn-success"></div>
				<div><input type="reset" 	value="다시입력" 	class="btn btn-danger"></div>
			</div>
			
		</form>
	</div>
</div>	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>