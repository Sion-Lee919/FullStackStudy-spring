package member;

public class MemberDAO {
	MemberDTO dto;

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
