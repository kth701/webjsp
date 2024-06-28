package ex01.sam03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam03.service.MemberDAOServiceImpl;
import ex01.sam03.vo.MemberVO;

@SuppressWarnings("serial")
@WebServlet("/member/*")
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
		
		req.setCharacterEncoding("utf-8");
		String action = req.getPathInfo();
		
		System.out.println("--- action ");
		System.out.println(action);
		
		
		if (action != null && action.equals("/addMember.do")) {
			System.out.println(" 회원가입하는 dao요청하기");
			
			String id = req.getParameter("user_id");
			String pw = req.getParameter("user_pw");
			String name = req.getParameter("user_name");
			String email = req.getParameter("user_email");
			
			MemberVO vo = MemberVO.builder()
					.id(id).pwd(pw).name(name).email(email)
					.build();
			
			int result = memberDAOServiceImpl.registerMember(vo);
			
		} else if (action != null && action.equals("/delMember.do")) {
			System.out.println(" 회원탈퇴하는 dao요청하기");
			
			
		} else if (action != null && action.equals("/modMember.do")) {
			System.out.println(" 회원수정하는 dao요청하기");
			
			
		}

		List<MemberVO> list = memberDAOServiceImpl.listMembers();

		
		
		// 클라이언트에 응답
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String htm_str = """
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>구구단 View Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


		</head>
		<body>
		<div class="container ">	
		<h3>회원 정보 List</h3>
		<table class="table table-success table-striped">
		  <thead>
		    <tr>
		      <th scope="col" >아이디</th>
		      <th scope="col" >비밀번호</th>
		      <th scope="col" >회원이름</th>
		      <th scope="col" >회원이메일</th>
		      <th scope="col" >가입일자</th>
		    </tr>
		  </thead>
		  <tbody>
						""";
				//---------------------------------
				
				for(MemberVO member : list ) {
					//System.out.println(dan*i);
					htm_str += "<tr>";
					htm_str += "	<td>" + member.getId()+"</td>";
					htm_str += "	<td>" + member.getPwd()+"</td>";
					htm_str += "	<td>" + member.getName()+"</td>";
					htm_str += "	<td>" + member.getEmail()+"</td>";
					htm_str += "	<td>" + member.getJoinDate()+"</td>";
					htm_str += "</tr>";
				};
				
				
				//------------------------------
				htm_str += """

		  </tbody>
		</table>					
		</div>	
			
			
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
		</body>
		</html>				
						""";
				
		writer.print(htm_str);
		
		
		
	}
}
