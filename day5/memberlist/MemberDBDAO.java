package annotation.springmvc.memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("dbdao")
public class MemberDBDAO {
	

	@Override
	ArrayList<MemberDTO> getPagingMemberList(int page, int cnt){
		
	}
	
	@Override
	ArrayList<MemberDTO> getNonPagingMemberList() {
		
	}

}
