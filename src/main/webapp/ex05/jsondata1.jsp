<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Data</title>
<%@include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container">
		<div>
			<a href="#" id="checkJson"  class="link-underline-danger">JSON Data 보내기</a>
		</div>
		<div>
			<a href="#" id="checkJson2"  class="link-underline-danger">JSON Data2 보내기</a>
		</div>
		<div>
			<a href="#" id="checkJson3"  class="link-underline-danger">JSON Data3 보내기</a>
		</div>
			<div>
			<a href="#" id="checkJson4"  class="link-underline-danger">Ajax 서버와 JSON Data 보내기/받기</a>
		</div>
		<div id="output" class="alert alert-primary -m-3">
			result
		</div>
	</div>
	
	
<!--  jQuery CDN 연결 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function(){
		
		$('#checkJson').click(function(){
			let jsonStr = '{ "name":	["홍길동","이순신","동길이"] }'
			
			/* console.log(jsonStr)
			console.log(jsonStr.name)
			console.log(jsonStr.name[0])
			console.log(jsonStr.name[1])
			console.log(jsonStr.name[2]) */
			console.log(" json형식 문자열:",jsonStr)
			
			let jsonInfo = JSON.parse(jsonStr);// JSON구조의 문자형->JSON자료형
			console.log(jsonInfo);
			
			output = "======<br>"
			for(let idx in jsonInfo.name){
				output += jsonInfo.name[idx]+"<br>"
			}
			console.log(output); // 문자열
			
			$('#output').html(output)// HTML구조형식인 무자열 => HTML객체로 전환
		})
		
		$('#checkJson2').click(function(){
			console.log('checkJson2 click....');
			
			var jsonStr = '{ "name":"홍길동", "age":10, "gender":"남자", "nickname":"돌이" }';
			console.log(jsonStr)
			
			var jsonObj = JSON.parse(jsonStr);// 문자열 -> JSON객체 전환
			console.log(jsonObj)
			console.log(jsonObj.name, jsonObj.age)
			
			// JSON객체 -> 문자열
			var jsonStr2 = JSON.stringify(jsonObj)
			console.log(jsonStr2)
			
			var output = "====<br>";
			output += "이름: "+jsonObj.name +"<br>";
			output += "나이: "+jsonObj.age +"<br>";
			output += "성별: "+jsonObj.gender +"<br>";
			output += "별명: "+jsonObj.nickname +"<br>";
			console.log(output);
			
			$('#output').html(output);
			
		})
		
		$('#checkJson3').click(function(){
			var jsonInfoArray = {
				member: [ 
					{name:"홍길동", age:10, gender:"남자", nickname:"돌이" },
					{name:"동순이", age:11, gender:"여자", nickname:"순둥이" },
					{name:"길순이", age:12, gender:"여자", nickname:"뺑실이" }
					]
			};
			console.log(jsonInfoArray) // JSON객체
			console.log(jsonInfoArray.member[0].name,jsonInfoArray.member[0].age);
			
			var jsonArrayStr = JSON.stringify(jsonInfoArray);// JSON객체 -> 문자열
			console.log(jsonArrayStr)
			
			var jsonObjArray = JSON.parse(jsonArrayStr);// 문자열 -> JSON객체
			console.log(jsonObjArray)
			
		});
		
		$('#checkJson4').click(function(){
			var _jsonInfoArray = {
					member: [ 
						{name:"홍길동", age:10, gender:"남자", nickname:"돌이" },
						{name:"동순이", age:11, gender:"여자", nickname:"순둥이" },
						{name:"길순이", age:12, gender:"여자", nickname:"뺑실이" }
						]
				};
			// 배열  구조
/* 			var _jsonInfoArray2 = [
				{
					member: [ 
						{name:"홍길동", age:10, gender:"남자", nickname:"돌이" },
						{name:"동순이", age:11, gender:"여자", nickname:"순둥이" },
						{name:"길순이", age:12, gender:"여자", nickname:"뺑실이" }
						]
				},
				{
					member: [ 
						{name:"홍길동", age:10, gender:"남자", nickname:"돌이" },
						{name:"동순이", age:11, gender:"여자", nickname:"순둥이" },
						{name:"길순이", age:12, gender:"여자", nickname:"뺑실이" }
						]`
				}
			];	 */		
			
			$.ajax({
				type: "post",
				url: "/webjsp/json",
				async: false, // false: 동기식, true: 비동기식(기본)
				data: {
					jsonInfoArray : JSON.stringify(_jsonInfoArray)
				},
				dataType: "text", // 전송받을 데이터형식: json, xml, text,...
				success: function(data, textStatus){
					console.log("정상 처리")
					
					console.log("서버로 부터 받은 JSON객체 문자열")
					console.log(data);
					
					let jsonMembers = JSON.parse(data) ;
					console.log(jsonMembers.members);

					let html_out = `
						<table class="table  table-bordered">
						  <thead>
						    <tr>
						      <th scope="col">이름</th>
						      <th scope="col">나이</th>
						      <th scope="col">성별</th>
						      <th scope="col">닉네임</th>
						    </tr>
						  </thead>
						  <tbody>
					`;
					
					
					for (let i=0; i<jsonMembers.members.length;i++ ){
						
					/*  console.log("--------")
						console.log(jsonMembers.members[i].name)
						console.log(jsonMembers.members[i].age)
						console.log(jsonMembers.members[i].gender)
						console.log(jsonMembers.members[i].nickname) */
						
						html_out += "<tr>";
						html_out += "	<td>"+jsonMembers.members[i].name +"</td>";
						html_out += "	<td>"+jsonMembers.members[i].age + "</td>";
						html_out += "	<td>"+jsonMembers.members[i].gender + "</td>";
						html_out += "	<td>"+jsonMembers.members[i].nickname + "</td>";
						html_out += "</tr>";
						
					}// outer for
					
					html_out +=`
						  </tbody>
						</table >
					`;
					
					console.log(html_out);
					$('#output').html(html_out);
					
				},
				error: function(){ alert('에러 발생')},
				complete: function(){ console.log('작업 완료')}
			});
		})
	
		
	});
</script>
</body>
</html>