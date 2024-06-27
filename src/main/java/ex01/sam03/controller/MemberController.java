package ex01.sam03.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam03.dao.MemberDAOImpl;
import ex01.sam03.service.MemberDAOServiceImpl;
import ex01.sam03.vo.MemberVO;

@SuppressWarnings("serial")
@WebServlet("/member")
public class MemberController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===> MemberController Servlet...");
		
		// controller -> service에게 요청 -> dao에게 요청
		MemberDAOServiceImpl memberDAOServiceImpl = new MemberDAOServiceImpl();
		
		List<MemberVO> list = memberDAOServiceImpl.listMembers();
		list.stream().forEach( member -> {
			System.out.println(member.getId());
			System.out.println(member.getPwd());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println(member.getJoinDate());
		});
		
	}
}
