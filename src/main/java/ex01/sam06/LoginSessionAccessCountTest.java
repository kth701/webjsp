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
@WebServlet("/login_session_count")
public class LoginSessionAccessCountTest extends HttpServlet{
	
	ServletContext context = null;
	List user_list = new ArrayList();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		context = getServletContext();// 애플리케이션 전체에 사용할 수 있는 객체생성
		HttpSession session = req.getSession();
		System.out.println("로그인 세션 ID:"+session.getId());
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		LoginBindingListenerImpl loginUser = new LoginBindingListenerImpl(user_id, user_pw);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			
			user_list.add(user_id);// 로그인 접속자의 아이디 저장
			context.setAttribute("user_list", user_list);
		}
		
		
		out.println("</html><head>");
		out.println("<body>");
		
		out.println(" 아이디 "+loginUser.user_id+"<br>");
		out.println(" 총 접속자수는 "+LoginBindingListenerImpl.total_user+"<br>");
		out.println(" 접속 아이디<br>");
		
		List list = (ArrayList) context.getAttribute("user_list");
		
		for(int i=0; i<list.size(); i++) {
			out.println(list.get(i)+"<br>");
		}
		out.println("<a href='/webjsp/login_session_logout?user_id="+user_id+"'>로그아웃</a>");
		
		out.println("</body></html>");
		
	}
}
