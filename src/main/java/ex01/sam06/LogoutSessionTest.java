package ex01.sam06;

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
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login_session_logout")
public class LogoutSessionTest extends HttpServlet {
	ServletContext context = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		context = getServletContext();
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		session.invalidate();// 세션 소멸
		
		List user_list = (ArrayList) context.getAttribute("user_list");
		user_list.remove(user_id); // 로그아웃시 => 리스트에서 접속자 아이디 제거
		
		context.removeAttribute("user_list");// 기존에 context값 삭제후
		context.setAttribute("user_list", user_list);// 변경된 context값 저장
		
		out.println("<br>로그아웃했습니다.");
		
		
		
	}
}
