package ex01.sam03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ex01.sam03.vo.MemberVO;

// DB처리 
public class MemberDAOImpl implements MemberDAO {
	// 1-1 db연결 설정하는 멤버변수
	
	// mariadb 연결
	//private static final String url = "jdbc:mariadb://localhost:3306/webdb(DB이름)";
	
	// oracle 연결
//	private static final String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	private static final String user = "c##user";
//	private static final String pwd = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 2-1. 커넥션 풀
	private DataSource dataSource;
	
	public MemberDAOImpl() {
		// 컨네션 풀 적용시 미사용됨.
		// db연결하는 메서드 호출
		// connDB();
		
		// 2-2. 커넥션 풀 사용
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
	
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		
	}
	
	// 회원 목록
	@Override
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// 2-3. 커넥션 풀 적용
			conn = dataSource.getConnection(); 
			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id 	= rs.getString("id");
				String pwd 	= rs.getString("pwd");
				String name = rs.getString("name");
				String email  = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	// 회원 등록
	public int registerMember(MemberVO memberVO) {
		int result = 0;
		System.out.println("registerMember:"+memberVO);
		String sql = "";
		try {
			conn = dataSource.getConnection();
			sql = "insert into t_member (id, pwd, name, email) values (?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
			System.out.println("insert after: "+result);
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}
	// 회원 수정
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		return result;
	}
	// 회원 조회
	public MemberVO viewMember(String id) {
		MemberVO vo = new MemberVO();
		return vo;
	}
	// 회원 삭제
	public int removeMember(MemberVO memberVO) {
		int result = 0;
		return result;
	}
	
	
	
	
	// DB연결하기
	private void connDB() {
		// 컨네션 풀 적용시 미사용됨.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle 드라이브 로딩 성공");
			
			//conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("conn : "+conn);
			System.out.println("Oracle Connection 성공");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}



}


/*
 * 커넥션풀(ConnectionPool) : 미리 데이터베이스와 연결시킨 상태를 유지하는 기술
 * 
 * 톰캣 컨테이너 자체적으로 ConnectionPool기능 제공해줌.
 * 
 * javax.sql.DataSource클래스 이용 -> ConnectionPool 객체
 * JNDI(Java Naming and Directory Interface) : 필요한 자원을 key/value을 저장한 후 필요할 때 키로 통해 값을 호출
 * 
 */



