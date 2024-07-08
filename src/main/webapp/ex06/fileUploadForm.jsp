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
		<h1>File Upload Form</h1><hr>
		
		<form action="/webjsp/upload.do"  method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="formFile" class="form-label">파일1</label>
		  		<input class="form-control" type="file" name="file1" id="formFile" >
			</div>
			<div class="mb-3">
			  <label for="formFile" class="form-label">파일2</label>
		  		<input class="form-control" type="file" name="file2" id="formFile" >
			</div>
			매개변수1:<input class="form-control" type="text" name="param1"><br>
			매개변수1:<input class="form-control" type="text" name="param2"><br>
			매개변수1:<input class="form-control" type="text" name="param3"><br>
			매개변수1:<input class="form-control" type="text" name="param4"><br>
			
			<input class="form-control" type="submit" value="업로드"><br>
		</form>
	</div>

</body>
</html>