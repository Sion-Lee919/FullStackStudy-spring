package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ww1") // 기본적으로 id=memberDAO
public class MemberDAO {
	@Autowired //MemberDTO 타입 BEAN 있으면(ID값 상관없이) 자동 주입 dean 여러개있을때 @Qualifier 사용하여 한개 지정
	@Qualifier("dto3")
	MemberDTO dto;
	
	MemberDAO(){}
	
	MemberDAO(MemberDTO dto){
		this.dto = dto;
	}
	
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	
	public void insertMember() {
		System.out.println(dto.getId()+" 회원님 정상적으로 회원가입되셨습니다.");
	}
	
	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPw()==1111) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
