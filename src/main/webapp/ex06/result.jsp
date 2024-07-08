<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpLoadForm</title>

<c:set var="file1" value="${param.param1 }" />
<c:set var="file2" value="${param.param2 }" />

</head>
<body>
	
	<div class="container">
		<h1>DownLoad Form</h1><hr>
		
		<div>매개변수1 : <c:out value="${file1 }" /></div>
		<div>매개변수2 : <c:out value="${file2 }" /></div>
		
		<c:if test="${not empty file1 }">
			<!--  서버에 이미지 다운로드 요청하여 이미지를 화면표시
			요청 응답이 없으면 이미지가 표시 되지 않음 -->
			<img src="${ctx }/download.do?fileName=${file1}" width=300 height=300 />
		</c:if>
		<c:if test="${not empty file2 }">
			<img src="${ctx }/download.do?fileName=${file2}" width=300 height=300 />
		</c:if>
		
		<div>파일 내려받기</div>
		<a href="${ctx }/download.do?fileName=${file2}">이미지 다운로드</a>

	</div>

</body>
</html>