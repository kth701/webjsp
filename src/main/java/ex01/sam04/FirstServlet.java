package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first01")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 1. redirect 포워딩
		//   : 웹브라우저에서 재요청하는 방식( http://localhost:8999/webjsp/second01)
		
		//resp.sendRedirect("second01");
		
		// 2. refresh 포워딩
		// : 웹브라우저에 1초 후 서블릿 second로 재요청
		// resp.addHeader("Refresh", "3; url=second01");
		
		// 3. location 포워딩: 자바스크트 이용
		//writer.print("<script type='text/javascript'>");
		//writer.print(" 	location.href='second01'");
		//writer.print("</script>");
		
		// 4. 포워딩 할 때 데이터 전달하기
		// resp.sendRedirect("second02?name=lee");
		
		// 5. dispach 포워딩
		// redirec방법과 다른 점은 클라이언트의 웹브라우저를 거치지 않고
		// 서버에 포워딩이 진행
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("second01");
		//RequestDispatcher dispatcher = req.getRequestDispatcher("second02?name=hong");
		//dispatcher.forward(req, resp);
		
		// 서블릿에서 다른 서블릿(JSP,..)으로 포워딩 할 때 데이터 전달 방식
		// GET: 데이터 양이 적을 때, 대량의 데이를 고유 : 바인딩(binding)기능 사용
		// 바인딩: 데이터를 하나로 묶는 기능
		// 서블릿 관련 객체에 저장방법 : HttpServletRequest, HttpSession, ServletContext
		//                             : 저장된 자원(데이터)은 서블릿, JSP공유
		
		// 클라이언트에 요청했을 경우
		// sendRedirec방식 : 다른 서브릿으로 데이터를 전송 할 수 없음.
		//req.setAttribute("address", "부산시");
		//resp.sendRedirect("second03");
		
		// 서버에서 요청했을 경우
		req.setAttribute("address", "부산시");
		req.setAttribute("age", "10");
		RequestDispatcher dispatcher = req.getRequestDispatcher("second03");
		dispatcher.forward(req, resp);
		
		
	}

}




















/*
포워드(forward) 기능
: 하나의 서블릿에서 다른 서블릿이나 JSP와 연동하는 방식
: 요청(request)에 포함된 정보를 다른 서블릿이나 JSP와 공유
: 요청(request)에 정보를 포함시켜 다른 서브릿에 전달
: 모델2 개발시 서블릿에서 JSP로 데이터 전달


- redirect
	: HttpServletResponse객체의 sendRedirect()메서드
- Refresh
	: HttpServletResponse객체의 addHeader()메서드
- location
	: 자바스크립트 location객체의 href속성
- dispatch
	: 일반적으로 포워딩  기능을 지칭
	

*/