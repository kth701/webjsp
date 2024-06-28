package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/second03")
public class SecondServlet03 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		String address =  (String)req.getAttribute("address");
		int age = Integer.parseInt((String)req.getAttribute("age"));
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html><body>");
		writer.println("전송받은 데이터 주소:"+address+"<br>");
		writer.println("전송받은 데이터 나이:"+(age+1));
		writer.println("</body></html>");
		
	}
}
