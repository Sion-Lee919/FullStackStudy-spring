package annotation.springmvc.memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("listservice")
public class ListService {
	
	@Autowired
	MemberDBDAO bdda;
	
	
	
	public MemberDBDAO getBdda() {
		return bdda;
	}



	public void setBdda(MemberDBDAO bdda) {
		this.bdda = bdda;
	}



	public ArrayList<MemberDTO> getMemberList(int page) {
		int cnt=3;
		if(page ==0) {
			ArrayList<MemberDTO> a = bdda.getNonPagingMemberList();
			return a;
		}
		else {
			ArrayList<MemberDTO> b = bdda.getPagingMemberList(page,cnt);
			return b;
		}
		
	}
}
