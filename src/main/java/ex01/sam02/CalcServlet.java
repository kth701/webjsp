package ex01.sam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam02.dto.AddCalc;

@SuppressWarnings("serial")
@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("CalcServlet init()...");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		// String -> int 
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt( req.getParameter("num2"));
		
		// 덧셈 계산기 객체생성
		AddCalc addCalc = AddCalc.builder()
				.num1(num1)
				.num2(num2)
				.build();
		
		int addResult = addCalc.result();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		String result = "";
		result += "<html>";
		result += "<body>";
		
		result += "<h1>계산 결과</h1>";
		result += "<hr/>";
		
		result +=  num1 +" + " + num2 +" = "+addResult;
		
		result += "</body>";
		result += "</html>";

		out.print(result);
		
		
	}
}
