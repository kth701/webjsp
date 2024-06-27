package ex01.sam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login2")
public class LoginServletResponse extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServletResponse init()...");
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
		System.out.println("doGet(), doPost() ...");
		
		// 서버 -> 클라언트에게 정보 전달 (html구조)
		// HTML데이터 : text/html, 텍스트데이터: text/plain, XML테이터: appplication/xml
		
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		
		// 응답: Response 처리
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String 	data = "";
				data += "<html>"; 
				data += "	<body>";
				data += "		아이디:"+id;
				data += "		패스워드:"+pw;
				data += "	</body>";
				data += "</html>";
		
		out.print(data);
		
		
	}
}
