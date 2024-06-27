package ex01.sam01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// 서블릿 요청시 맨 처음 한번만 호출
		System.out.println("init() 메서드 호출");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번호출 : get방식으로 요청시
		System.out.println("doGet() 메서드 호출");
	}
	@Override
	public void destroy() {
		// 서블릿이 기능을 수행하고 메모리에서 소멸될 때 호출
		System.out.println("destory() 메서드 호출");
	}

}
