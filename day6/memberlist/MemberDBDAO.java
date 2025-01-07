package annotation.springmvc.memberlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("dbdao")
public class MemberDBDAO {

	//내 정보 조회
	/*public MemberDTO getMember(String id,int pw) {
		MemberDTO dto = null;
		Connection con = null;
		try {
	
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		//회원 존재여부+ 암호여부
		String selectSQL = "select id, name,pw,phone,email,to_char(regdate,'yyyy\"년도\"mm\"월\"dd\"일\"') regdate from members where id=?";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
		pt1.setString(1, id);
	 	ResultSet rs = pt1.executeQuery();

	 	if(rs.next()) {
	 		if(pw == rs.getInt("pw")) {
	 			dto = new MemberDTO();
	 			dto.setId(rs.getString("id"));
	 			dto.setName( rs.getString("name"));
	 			dto.setPw( rs.getInt("pw"));
	 			dto.setPhone (rs.getString("phone"));
	 			dto.setEmail (rs.getString("email"));
	 			dto.setRegdate(rs.getString("regdate"));	 			
	 		}
	 		else {
	 			dto = new MemberDTO();
	 			dto.setId(rs.getString("id"));
	 		}
	 	}	
	 	//else { dto는 이미 null이여서 쓸 필요가 없음
	 	//}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
		return dto;
	}
*/
	//회원리스트 조회 페이지
/*	public int getTotalCount() {
		int cm=0;
		Connection con = null;
		try {
	
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		//회원 존재여부+ 암호여부
		String selectSQL = "select count(*) cm from members";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
	 	ResultSet rs = pt1.executeQuery();
	 	
	 	if(rs.next()) {
	 		cm= rs.getInt("cm");
	 		
	 		}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
		return cm ;
	}
*/	
	//모든회원리스트
	public ArrayList<MemberDTO> getpagingMemberList(){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = "select * from members order by regdate desc";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;

	}
	
	
	//회원리스트 조회
	public ArrayList<MemberDTO> getpagingMemberList(int pagenumber, int count) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = 
		"select id, name, phone, email, regdate "
		+ "	from(select rownum r,  imsi.* "
		+ " from (select * from members order by regdate desc) imsi)" 
		+ " where r between ? and ?";
		
		int start = (pagenumber-1)*count + 1;
		int end = pagenumber * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;

	}//getMembers(int, int) end	


	
	
	//검색조회
	/*public ArrayList<MemberDTO> getMembers(String[] items, String word){
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

			Connection con = null;
			try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection
					(DBInfo.url, DBInfo.account, DBInfo.password);
			System.out.println("db 연결 성공");
			
			String selectSQL = "select * from members where "+items[0]+ " like ?";
			for (int i = 1; i < items.length; i++) {
				selectSQL += " or "+items[i]+" like ?"; //공백 정확하게 주기
			}
			System.out.println(selectSQL);
			
			PreparedStatement pt2 = con.prepareStatement(selectSQL);
			for (int i = 1; i <= items.length; i++) {
				pt2.setString(i, "%"+word+"%");
			}
			ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
			con.close();
			System.out.println("db 연결 해제 성공");
			//
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
				System.out.println("module-info.java 미설정 확인하세요 ");
			}catch(SQLException e) {
				System.out.println("db 연결 실패-연결 정보를 확인하세요");
				e.printStackTrace();//오류발생원인 추적하여 출력
			}finally {
				try {
					if(!con.isClosed()) {
						con.close();
						System.out.println("finally - db 연결 해제 성공");
					}
				}catch(Exception e) {}
			}
			return list;

		}//getMembers(int, int) end		
	*/
}//class end

