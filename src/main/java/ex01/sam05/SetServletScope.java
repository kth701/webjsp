package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/setscope")
public class SetServletScope extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//------------------------------//
		String context = req.getContextPath();
		String url = req.getRequestURL().toString();
		String mapping = req.getServletPath();
		String uri = req.getRequestURI();
		
		System.out.println("-> request 패턴");
		System.out.println("컨텍스트이름: "+context);
		System.out.println("전체경로: "+url);
		System.out.println("매핑이름: "+mapping);
		System.out.println("URI: "+uri);
	
		//------------------------------//
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String ctxMesg = "context에 바인딩됩니다.";
		String sesMesg = "session에 바인딩됩니다.";
		String reqMesg = "request에 바인딩됩니다.";
		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		req.setAttribute("request", reqMesg);
		
		out.print("바인딩을 수행합니다.");
		
		
	}


}
