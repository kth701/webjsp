package ex05.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;

@SuppressWarnings("serial")
@WebServlet("/json")
public class AjaxTest2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/json 요청 받았음.");

		// 문자형 숫자 -> 숫자: Integer.parse("문자열값")
		// json형식 문자열을 받음 -> json객체로 전환
		
		 String jsonInfo = req.getParameter("jsonInfo");
		 System.out.println("jsonInfo:"+jsonInfo);
		 

		/*
		  try { 
			  JSONParser jsonParse = new JSONParser(jsonInfo); 
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
		  }
		  */

		 

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		String param = req.getParameter("param");
		out.print("Json데이터 요청받았습니다.");

	}
}
