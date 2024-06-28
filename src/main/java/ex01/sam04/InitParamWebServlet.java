package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class InitParamWebServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번호출 : get방식으로 요청시
		System.out.println("doGet() 메서드 호출");
		
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		writer.print("<html><body>");
		writer.print("<h1>ServletConfig web.xml 구조: 매개변수 데이터 가져오기</h1>");
		writer.print(email+"<br/>"+tel+"<br/>");
		writer.print("</body></html>");
	}

}
