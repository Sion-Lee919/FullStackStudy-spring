package memberService;

public class MemberBasicService implements MemberService {
	
	MemberBasicService(){
		System.out.println("MemberBasicService 객체 생성");
	}
	
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void registerMember() {
		boolean b = dao.selectMember();
		if(b == false) {
			dao.insertMember();
		}
	}
	
}
