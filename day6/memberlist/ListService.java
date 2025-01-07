package annotation.springmvc.memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("listservice")
public class ListService {
	
	@Autowired
	MemberDBDAO bdda;
	
	public ArrayList<MemberDTO> getMemberList(int page) {
		int cnt=3;
		if(page ==0) {
			return bdda.getpagingMemberList();
			
		}
		else {
			return bdda.getpagingMemberList(page,cnt);
			
		}
		
	}
}
