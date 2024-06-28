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
@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 애플리케이션 전체에서 사용될 공통 저장소
		ServletContext ctx = getServletContext();
		
		List list = new ArrayList();
		list.add("이순신");
		list.add(10);
		
		// ServletContext에 바인딩된 데이터는 모든 서블릿들(사용자)이 접근 가능
		// 웹애플리케이션에서 모든 사용자가 공통으로 사용하는 데이터
		ctx.setAttribute("memberInfo", list);
		
		writer.print("<html><body>");
		writer.print("이순인 10 설정");
		writer.print("</body></html>");
		
		
		
		
		
		

		
		
	}
}





/*

ServletContext :

톰캣 컨테이너 실행 시 각 컨텍스트(웹 애플리케이션)마다 한 개의 객체 생성
애플리케이션 전체의 공통 자원이나 정보를 미리 바인딩해서 서블릿들이 공유하여 사용

- 서블릿에서 파일 접근 기능
- 자원 바인딩 기능
- 로그 파일 기능
- 컨텍스트에서 제공하는 설정 정보 제공 기능

*/