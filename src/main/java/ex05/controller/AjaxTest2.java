package ex05.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ex05.vo.JsonVO;



@SuppressWarnings("serial")
@WebServlet("/json")
public class AjaxTest2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/json 요청 받았음.");

		// 문자형 숫자 -> 숫자: Integer.parse("문자열값")
		// json형식 문자열을 받음 -> json객체로 전환
		
		 String jsonInfoArray = req.getParameter("jsonInfoArray");
		 System.out.println("jsonInfoArray:"+jsonInfoArray);
		 
		 List<JsonVO> list = new ArrayList<JsonVO>();
		 
		  try { 
			  JSONParser jsonParser = new JSONParser(); // JSONParser객체 생성
			  
			  // 1.  배열 구조 일 경우: JSON객체 배열 생성
			  //JSONArray jsonArray  = (JSONArray) jsonParser.parse(jsonInfoArray);// 문자열 -> JSON객체로 전환
			  
			  // 2. 배열 구조가 아닌 단일 객체 일 경우 : JSON객체 생성
			  JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfoArray);// 문자열 -> JSON객체로 전환
			  
				/*
				 * System.out.println("------------"); System.out.println("받은 JSON데이터");
				 * System.out.println(jsonObject .toJSONString());
				 */
			  
			  System.out.println("--- 회원 정보");
			  System.out.println(jsonObject.get("member"));
			  
			  JSONArray jsonArray = (JSONArray) jsonObject.get("member");			  
 
			  System.out.println("member 값:배열구조");
			  for (int i=0; i<jsonArray.size(); i++) {
				  JSONObject memberInfo = (JSONObject) jsonArray.get(i);
				  
//				  System.out.println((i+1)+": ------");
//				  System.out.println(memberInfo.get("name"));
//				  System.out.println(memberInfo.get("age")); 
//				  System.out.println(memberInfo.get("gender"));
//				  System.out.println(memberInfo.get("nickname"));
				  
				  System.out.println("JSON 속성값 String -> VO에 전달");
				  
				  String name 		=  memberInfo.get("name").toString();
				  int age			= Integer.parseInt(memberInfo.get("age").toString());
				  String gender 	= memberInfo.get("gender").toString();
				  String nickname	= memberInfo.get("nickname").toString();
				  
				  JsonVO vo = new JsonVO(name, age, gender, nickname);
				  System.out.println(vo.toString());
				  
				  list.add(vo);// 리스트 구조에 vo객체 추가 
			  };
			  
			  System.out.println("== json data  to vo list");
			  System.out.println(list);

			  
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
		  }
		
		  


		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		System.out.println("-------");
		System.out.println("자바객체data -> JSON -> String -> 전송");
		System.out.println("-------");
		
		JSONObject members = new JSONObject();
		JSONArray valueArray = new JSONArray();
		
		
		for (JsonVO vo : list) {
			//System.out.println(vo);
			
			JSONObject memberInfo = new JSONObject();
			
			memberInfo.put("name", vo.getName());
			memberInfo.put("age", vo.getAge());
			memberInfo.put("gender", vo.getGender());
			memberInfo.put("nickname", vo.getNickname());
			
//			System.out.println("-- json");
//			System.out.println(memberInfo.toJSONString());
			
			valueArray.add(memberInfo);// JSON 배열에 JSON객체 추가
		}
	
		members.put("members", valueArray);	//System.out.println("members json: "+members.get("members"));
		String jsonMembers = members.toJSONString();// JSON객체 -> 문자열 
		System.out.println(jsonMembers);

		
		out.print(jsonMembers);

	}
}
