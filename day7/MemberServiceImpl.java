package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<MemberDTO> memberList() {
		int count = dao.memberCount();
		MemberDTO dto = new MemberDTO();
		dto.setPw(count);
		List<MemberDTO> list = dao.memberList();
		list.add(dto);
		return list;
	}

	@Override
	public MemberDTO oneMember(String id) {
		return dao.oneMember(id);
	}

	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO db_dto = dao.oneMember(dto.getId());
		if(db_dto != null) {
			return "아이디 중복 - 회원가입 불가능합니다.";
		}
		else {
			dao.insertMember(dto);
			return "정상적으로 회원 가입 되었습니다.";
		}
	}

	@Override
	public String modifyMember(MemberDTO dto) {
		MemberDTO db_dto = dao.oneMember(dto.getId());
		if(db_dto == null) {
			return "수정할 회원정보가 없습니다";
		}
		else {
			dao.updateMember(dto);
			return "정상적으로 회원 정보 수정되었습니다.";
		}
	}

	@Override
	public String deleteMember(String id) {
		MemberDTO db_dto = dao.oneMember(id);
		if(db_dto == null) {
			return "삭제할 회원정보가 없습니다";
		}
		else {
			dao.deleteMember(id);
			return "정상적으로 회원 정보 탈퇴되었습니다.";
		}
	}
	
	@Override
	public List<MemberDTO> memberList(String month) {
		return dao.month(month);
	}
	
	@Override
	public List<MemberDTO> memberPagingList(ArrayList list) {
		return dao.memberPagingList(list);
	}
	
	@Override
	public List<MemberDTO> memberSearchList(HashMap map) {
		return dao.memberSearchList(map);
	}
	@Override
	public List<MemberDTO> memberSearchList(MemberDTO dto) {
		return dao.memberSearchList2(dto);
	}
	
	
	
}
