<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<% 
	request.setCharacterEncoding("utf-8"); 
	String title1 = "Hello World";

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포매팅</title>
</head>
<body>
	<h3>포매팅 태그 라이브러리</h3>
	<hr>
	<h2>fmt</h2>
	<c:set var="price" value="1000000" />
	<div>
	형식 없이 출력 하기 : <c:out value="${price }" />
	</div>
	<div>
		통화 표시하기: 
		<fmt:formatNumber value="${price}" 
				type="currency" currencySymbol="\\"
				groupingUsed="true"  />
	</div>
	<div>
		<c:set var="price2" value="0.12" />
		퍼센트 표시: 
		<fmt:formatNumber value="${price2}" 
				type="percent"
				groupingUsed="false"  />
	</div>
	<hr>
	<h2>formatDate</h2>
	<hr>
	<c:set var="now" value="<%=new Date() %>"/><br>
	<c:out value="${now }" />
	<hr>
	
	<fmt:formatDate value="${now }" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${now }" type="time"/><br>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:formatDate value="${now }" type="both" pattern="YYYY-MM-dd :hh:mm:ss"/><br>
	<hr>
	한국 현재 시간: 
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:timeZone value="America/New York">
		뉴욕 현재 시간:
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
	<hr>
	<h2>문자열 처리</h2>
	<hr>
	<c:set var="title1" value="<%=title1 %>"/>
	<c:set var="title2" value="쇼핑몰 중심 도시"/>
	<c:set var="str1" value="중심"/>
	
	title1 [<c:out value="${title1 }"/>]<br>
	title2 [<c:out value="${title2 }" />]<br>
	str1 [<c:out value="${str1 }"/>]
	<div>
	fn:length(title1) => ${fn:length(title1) }<br>
	${fn:toUpperCase(title1) }<br>
	${fn:toLowerCase(title1) }<br>
	
	${fn:substring(title1, 3, 6) }<br>
	${fn:trim(title1) }<br>
	${fn:replace(title1," ", "/") }<br>
	
	포함여부: ${fn:contains(title1,"H") }<br>
	${fn:contains(title2,str1) }<br>
	문자열 위치: ${fn:indexOf(title1,"l") }<br>
	
	</div>
	
	
</body>
</html>