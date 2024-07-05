<%@page import="ex01.sam03.vo.MemberVO"%>
<%@page import="ex01.sam03.dao.MemberDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--  taglib디렉티브   -->
<%
	String address = "부산";
	String ctxPath = request.getContextPath();
	
	//데이터 List
	List dataList = new ArrayList();
	dataList.add("Hello");
	dataList.add("World");
	dataList.add("안녕하세요");
	
	System.out.println(dataList);
	
	// DAO
	List<MemberVO>  listMember = new ArrayList();
	MemberDAOImpl dao = new MemberDAOImpl();
	listMember = dao.listMembers();
	
	System.out.println(listMember);
	
	
%>
<!--  변수  -->
<c:set var="id" 	value="hong" 			scope="page" />
<c:set var="name" 	value="홍길동" 			scope="page" />
<c:set var="address" value="<%=address%>" 	scope="page" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!--  c:choose -->
<%-- 숫자타입을 값을 설정 : ${숫자}형식으로 설정 --%>
<c:set var="score" 	value="${10}" scope="page" />

<!-- dataList 변수 set -->
<c:set var="list" value="<%=dataList%>"/>

<!-- DAO 데이터 List -->
<c:set var="memberList" value="<%=listMember%>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 표준 태그 라이브러리</title>
<%@include file="/include/bootstrap_include.jsp" %>


</head>
<body>
<div class="container">
	<h1>JSTL 표준 태그 라이브러리</h1>
	<hr>
	<div>

	</div>
	<h4>c:set</h4>
	<div>
		아이디: ${id}<br>
		이름: ${name }<br>
		주소: ${address } <%=address %>
		<hr>
		객체 해재후<br>
		<c:remove var="address"/>
		주소: ${address }
		<hr>
		contextPath : ${contextPath } or  <%=ctxPath %>
	</div>
	
	<hr>
	<h4>c:if</h4>
	
	<c:if test="${ (id=='hong') && (name=='홍길동')}">
		<h3>아이디는 ${id }이고, 이름은 ${name }</h3>
	</c:if>
	<c:if test="${(score == 10)}">
		<h3>score = ${score }</h3>
	</c:if>
	<c:choose>
		<c:when test="${score > 10 }">${score }는 10보다 크다</c:when>
		<c:when test="${score == 10 }">${score }는 10과 동일</c:when>
		<c:otherwise>
			${score}는 10보다 작은 수입니다.
		</c:otherwise>
	</c:choose>
	<hr>
	EL형식: 문자형 숫자 -> 숫자형을 자동 전환<br>
	매개변수 score:  ${(param.score)}<br>
		<c:choose>
		<c:when test="${param.score > 10 }">${param.score }는 10보다 크다</c:when>
		<c:when test="${param.score == 10 }">${param.score }는 10과 동일</c:when>
		<c:otherwise>
			param.score: ${param.score}는 10보다 작은 수입니다.
		</c:otherwise>
	</c:choose>
	
	<hr>
	<h2>태그 요소를 반복 처리</h2>
	<hr>
	<div>
	<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
		<div>
			반복횟수: ${loop.count } => <a href="/webjsp/${i}/test${i}">
				${i}
			</a>
		</div>
	</c:forEach>
	</div>
	<hr>
	<h3>dataList</h3>
	<div>1. dataList =><%=dataList %></div>
	<div>2. dataList => ${list}</div>
	<hr>
	<c:forEach var="data" items="${list}">
		<h3>${data }</h3>
	</c:forEach>
	
	<c:set var="fruits"  value="사과, 파인애플, 바나나"   />
	<c:forTokens var="token" items="${fruits}" delims=",">
			${token }
	</c:forTokens>
	<hr>
	<h3>DAO memberList</h3>
	<table class="table table-bordered">
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td><h3>${member.id }</h3></td>
			<td><h3>${member.pwd }</h3></td>
			<td><h3>${member.name }</h3></td>
			<td><h3>${member.email }</h3></td>
			<td><h3>${member.joinDate }</h3></td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	
	
	<h3>c:url 적용: 포워딩 방식 연결</h3>
	<%-- /webjsp/ex07/jstl_url_resul.jsp?id=param.id값&name=param.id값 --%>
	
	<c:url var="urlTest" value="/ex04/jstl_url_resul.jsp">
		<c:param name="id" 		value="${param.id}" />
		<c:param name="name" 	value="${param.name}" />
	</c:url>
	<h2><a href="${urlTest}">JSTL에서 c:url을 이용하여 값 전달하기</a></h2>
	<hr>
	
<%-- 	<h1>c:redirect 적용 </h1>
 	<c:redirect url="/ex04/jstl_url_resul.jsp">
		<c:param name="id" 		value="${param.id}" />
		<c:param name="name" 	value="${param.name}" />
	</c:redirect> --%>
	<hr>
	<h3>c:out 적용</h3>
	<div>
	${param.id }, ${param.name }
	</div>
	<div>
		<c:out value="${param.id }" />
		<c:out value="${param.name }" />
		<hr>
		<c:out value="&lt"  escapeXml="true"/>
		<c:out value="&lt"  escapeXml="false"/>
	</div>
	
</div>	
</body>
</html>

<%-- 
JSTL : 스크립틀릿을 사용하지 않고 제어문, 반복문 등을 사용가능
--%>