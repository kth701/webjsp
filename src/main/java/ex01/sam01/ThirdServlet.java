package ex01.sam01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트에서 요청 방식 : "/webjsp/third "=> 서버에 인식방식 :"/third"
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// 서블릿 요청시 맨 처음 한번만 호출
		System.out.println("ThirdServlet init() 메서드 호출");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번호출 : get방식으로 요청시
		//System.out.println("ThirdServlet doGet() 메서드 호출");
		doHandle(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번호출 : post방식으로 요청시
		//System.out.println("ThirdServlet doPost() 메서드 호출");
		doHandle(req, resp);
	}
	@Override
	public void destroy() {
		// 서블릿이 기능을 수행하고 메모리에서 소멸될 때 호출
		System.out.println("ThirdServlet destory() 메서드 호출");
	}
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번호출 : post방식으로 요청시
		System.out.println("doHandle() 메서드 호출 ");
	}
	
	
}
