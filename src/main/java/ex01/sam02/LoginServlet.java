package ex01.sam02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init(): 서블리로딩 될 때 최초 한번 수행: 초기화작업");	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet() 방식으로 서버에 요청 ");
		
//		request.setCharacterEncoding("utf-8");// 전송된 데이터 utf-8 인코딩
//		String user_id = request.getParameter("user_id");
//		String user_pw = request.getParameter("user_pw");
//		System.out.println("아이디=>"+user_id);
//		System.out.println("아이디=>"+user_pw);
		
		doHandler(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost() 방식으로 서버에 요청 ");
//		doHandler(request, response);
	}
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet(),doPost  방식으로 서버에 요청 ");
		
		request.setCharacterEncoding("utf-8");// 전송된 데이터 utf-8 인코딩
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		// 하나의 매개변수에 여러 개의 값을 전달 받을경우
		String[] subject =  request.getParameterValues("subject");
		
		String address = request.getParameter("address");
		String[] size = request.getParameterValues("sel_size");

		
		System.out.println("아이디=>"+user_id);
		System.out.println("아이디=>"+user_pw);
		
		System.out.println("-----");
		Enumeration<String> enu = request.getParameterNames();
		
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			System.out.println(name);
		}
		System.out.println("-- 여러 개의 값 처리");
		Arrays.stream(subject).forEach( value -> {
			System.out.println(value);
		});
		System.out.println("----");
		System.out.println("거주지: "+address);
		
		Arrays.stream(size).forEach( value -> {
			System.out.println("사이즈: "+value);
		});

		
		
		
	}

}
