package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/getscope")
public class GetServletScope extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		
		// 애플리케이션에서 브라우저에 관계없이 자원 공유
		String ctxMesg = (String) ctx.getAttribute("context");
		// 애플리케이션에서 브라우저별로 별도로 자원 공유 (브라우저가 다르면 인식안됨)
		String sesMesg = (String) session.getAttribute("session");
		// 애플리케이션에서 요청관계에서만 자원공유
		String reqMesg = (String) req.getAttribute("request");
		
		
		out.print("context:"+ctxMesg+"<br>");
		out.print("context:"+sesMesg+"<br>");
		out.print("context:"+reqMesg+"<br>");
	}
}
