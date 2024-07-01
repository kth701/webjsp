package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginsession")
public class LoginSesstionTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		//System.out.println(user_id+","+user_pw);
		
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 세션 객체 생성
		HttpSession session = req.getSession();
		
		// 세션 객체 저장된 값 불러오기
		String session_user_id = (String) session.getAttribute("user_id");
		
		System.out.println("session_user_id:"+session_user_id);
		
		if (session_user_id == null) {// 새로 생성된 세션일 경우
			
			if (user_id != null) {
				
				session.setAttribute("user_id",  user_id);
				
				out.print("<a href='/webjsp/loginsession'>로그인 상태 확인</a>");
			} else {
				out.print("<a href='/webjsp/ex01/sam05/LoginSession.jsp'>다시 로그인하세요</a>");
				
				session.invalidate();
			}
				
			
		} else {// 기존 세션일 경우
			if (session_user_id != null && session_user_id.length() !=0) {
				out.print("안녕하세요 "+session_user_id+"님!!!");
			} else {
				out.print("<a href='/webjsp/ex01/sam05/LoginSession.jsp'>로그인 작업이 필요합니다.</a>");
				session.invalidate();
			}
		}
	}
}
