package ex01.sam06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginlistener")
public class LoginloginListenerTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		// 이벤트 핸들러 생성한후 세선에 저장
		LoginBindingListenerImpl loginUser = new LoginBindingListenerImpl(id, pw);	
		System.out.println("==> loginUser:"+loginUser);
		
		session.setAttribute("loginUser", loginUser);
		
		
		out.println("</html><head>");
		out.println("<script>");
		out.println("setTimout('history.go(0);', 5000");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println(" 아이디 "+loginUser.user_id+"<br>");
		out.println(" 총 접속자수는 "+LoginBindingListenerImpl.total_user+"<br>");
		out.println("</body></html>");
		
		
		
	}
}
