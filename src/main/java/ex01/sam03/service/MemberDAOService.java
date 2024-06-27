package ex01.sam03.service;

import java.util.List;

import ex01.sam03.vo.MemberVO;

public interface MemberDAOService {
	
	public List<MemberVO> listMembers();
	
	public int registerMember(MemberVO memberVO);

}
