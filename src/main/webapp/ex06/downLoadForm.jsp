<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpLoadForm</title>
<%@include file="/include/bootstrap_include.jsp" %>

</head>
<body>

	<div class="container">
		<h1>DownLoad Form</h1><hr>
		
		<form action="/webjsp/ex06/result.jsp"  method="get">

			<input type="hidden" name="param1" value="1.jpg" />
			<input type="hidden" name="param2" value="2.jpg" /><br>
			<input type="submit" value="이미지 다운로드" />
		</form>
	</div>

</body>
</html>