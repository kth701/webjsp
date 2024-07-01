package ex01.sam06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.swing.RepaintManager;

@SuppressWarnings("serial")
//@WebFilter("/*") // 클리어언트부터 요청시 모든 url에대해 필터 작업
//@WebFilter("/login/*) // 클라이언트 '/login/'이하 모든 경로는 필터 작업
@WebFilter("/loginfilter") // 특정 url에 대해서만 필터 작업
public class EncoderFilter extends HttpFilter implements Filter {
       
	ServletContext ctx;
	
    public EncoderFilter() {
        super();
    }

	public void destroy() {
		// 필터 소멸 시 종료 작업 처리
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("==> doFilter()");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String ctx = ((HttpServletRequest)request).getContextPath();
		String pathInfo  = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathInfo);
		
		String msg = 
				"Context 정보:" + ctx +
				"\nURI 정보: "+pathInfo + 
				"\n물리적 경로:"+realPath;
		System.out.println(msg);
		
		// 다음 필터로 넘기는 작업을 수행
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 생성시 초기화 작업
		System.out.println("==> filter init()");
		ctx = fConfig.getServletContext();
	}

}
