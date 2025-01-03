package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeTestController {
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model","a메소드 호출결과");
		mv.setViewName("aa");
		return mv;
	}
	
	@RequestMapping("/b")
	public String b() { //view 이름
		//모델 없다
		return "bb";
	}
	
	@RequestMapping("/c")
	public void c() { //view 이름 (자동매핑) - c.jsp
		System.out.println("리턴타입 void입니다");
	}
	
	@RequestMapping("/d")
	public void d(@ModelAttribute("dto") LoginDTO dto) {
		System.out.println("리턴타입 void입니다");
	}
	
	@RequestMapping("/e")
	public String e() {
		//a 메소트 호출 -model + aa.jsp 이동
		return "redirect:/a";
	}
}
