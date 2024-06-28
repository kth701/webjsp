package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 애플리케이션 전체에서 사용될 공통 저장소
		ServletContext ctx = getServletContext();
		
		List list = (ArrayList)ctx.getAttribute("memberInfo");
		
		String name = (String) list.get(0);
		int age = (Integer)list.get(1);
		
		writer.print("<html><body>");
		writer.print("SevletContext객체있는 데이터 가져오기");
		writer.print(name+","+age);
		writer.print("</body></html>");
		
		
		
		
		
		

		
		
	}
}
