package annotation.springmvc.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = memberservice.memberList();
		int membercount = memberservice.memberCount();
		mv.addObject("memberlist",list);
		mv.addObject("membercount",membercount);
		mv.setViewName("mybatis/memberlist");

		
		return mv;
	}
	
	@RequestMapping("/membersearchlist")
	public ModelAndView memberlist(String item, String searchword) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(item.equals("이름검색")) {
		map.put("colname", "name");
		map.put("colvalue", "%"+searchword+"%");
		}
		else if(item.equals("폰번호검색")) {
			map.put("colname", "phone");
			map.put("colvalue", "%"+searchword+"%");
			}
		else if(item.equals("이메일검색")) {
			map.put("colname", "email");
			map.put("colvalue", "%"+searchword+"%");
			}
		else if(item.equals("아이디검색")) {
			map.put("colname", "id");
			map.put("colvalue", "%"+searchword+"%");
			}
		List<MemberDTO> searchlist = memberservice.memberSearchList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",searchlist);
		mv.setViewName("mybatis/memberlist");
		
		return mv;
	}
}
