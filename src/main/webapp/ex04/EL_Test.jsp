<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%-- isELIgnored="false": 표현언어 활성화 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL(Expression Language)언어 테스트</h1>
	<hr>
	
	<h3> 산술 연산</h3>
	${100}<br>
	${100*20+3}<br>
	${"10"+5000}<br><!--  문자형 숫자와 숫자 : 자동으로 문자형숫자->숫자형으로 전환 -->
	<%-- ${"홍길동"+"동순이" }<br>문자형 끼리는 연산안됨 --%>
	<hr>
	${10+10}, ${10-2}, ${3*2}<br>
	나누기:  ${9/2 }, <%-- ${10 div 3 } --%><br>
	나머지: ${10%3 }, ${10 mod 9 }<br>
	<hr>
	<h3>비교연산</h3>
	${10 == 10 }, ${ 10 eq 10 }, ${"100"==100 }<br>
	${ 10 != 20}, ${20>10 }, ${100 gt 10 }<br>
	${100 < 20 }, ${100 le 20 }<br>
	${ not(10 != 20) }
	<hr>
	<h3>empty 연산자</h3>
	<jsp:useBean id="member" class="ex03.vo.MemberBean" scope="page" />
	<jsp:setProperty property="name" name="member" value="홍길동"/>
	
	<jsp:useBean id="array_member" class="java.util.ArrayList" scope="page" />
	
	member empty: ${empty member }<br>
	member not empty: ${ not empty member }<br>
	array_member empty: ${empty array_empty }<br>
	array_member not empty: ${not empty array_empty }<br>
	
</body>
</html>
