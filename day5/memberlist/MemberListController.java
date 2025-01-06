package annotation.springmvc.memberlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberListController {
	@Autowired
	ListService listservice;
	
	
	public ListService getListservice() {
		return listservice;
	}


	public void setListservice(ListService listservice) {
		this.listservice = listservice;
	}


	@RequestMapping("/memberlist")
	ModelAndView getList(int pagenum) {
		
		
	}
}
