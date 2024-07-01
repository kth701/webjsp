package ex01.sam06;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@WebListener
public class LoginBindingListenerImpl implements HttpSessionBindingListener{
	
	String user_id;
	String user_pw;
	
	static int total_user=0;
	
	public LoginBindingListenerImpl() {}
	public LoginBindingListenerImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {// 세션에 저장 시, 접속자 수를 증가
		System.out.println("사용자 접속:"+user_id);
		++total_user;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속해제:"+user_id);
		--total_user;
	}

}


/*
서블릿 관련 Listener API
 : 서블릿에서 발생하는 이벤트에 대한 적절할 처리를 해주는 리스너
 
 ServletContextAttributeListener: 속성 추가/삭제/수정 이벤트 발생시
 HttpSessionListener : 생성/소멸 이벤트 발생시
 ServletRequestAttributeListener: 요청 이벤트 발생 시
 HttpSessionAttributeListener: 속성 추가/삭제/수정 이벤트 발생시
 SerlvetContextListener: 생성/소멸 발생시
 HttpSessionActivationListener: 세션 활성화/비활성화 이벤트 발생시

*/