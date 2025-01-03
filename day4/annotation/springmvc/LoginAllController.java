package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController {
	//로그인 폼 요청처리
	//@RequestMapping("/loginform")
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	@GetMapping("login")
	public ModelAndView form() throws Exception {
		ModelAndView mv = new ModelAndView();
		//모델생성
		mv.addObject("title","로그인폼");
		//뷰 생성
		mv.setViewName("loginform");
		return mv;
	}
	
	//테스트6
		@PostMapping("login")
		public ModelAndView bbb(Model model, @ModelAttribute("model") LoginDTO dto) throws Exception {
			model.addAttribute("model2","Model객체로부터 전달되는 값");
			
			ModelMap map = new ModelMap();
			map.addAttribute("model3","ModelMap객체로부터 전달되는 값");
			map.addAttribute("model4","ModelMap객체로부터 전달되는 값");

			ModelAndView mv = new ModelAndView();
			mv.addAllObjects(map);
			
			mv.addObject("model5","ModelAndView객체로부터 전달되는 값");
			mv.setViewName("loginresult");
			
			return mv;
		}
	
	
	/*
	//테스트5
	@PostMapping("login")
	public ModelAndView bbb(@ModelAttribute("model") LoginDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
	/*
	//테스트4
			@PostMapping("login")
			public ModelAndView bbb(LoginDTO dto) throws Exception {
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("model",dto);
				mv.setViewName("loginresult");
				
				return mv;
			}*/
	
	/*
	//테스트3
		@PostMapping("login")
		public ModelAndView bbb(@RequestParam(value="id",required =false, defaultValue = "spring") String memberid, String pw) throws Exception {
			//모델로 저장
			LoginDTO dto = new LoginDTO();
			dto.setId(memberid);
			dto.setPw(pw);
			ModelAndView mv = new ModelAndView();
			mv.addObject("model",dto);
			mv.setViewName("loginresult");
			
			return mv;
		}*/
	
	/*
	//테스트2
	@PostMapping("login")
	public ModelAndView bbb(String id, String pw, int age) throws Exception {
		System.out.println(age);
		//모델로 저장
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("model",dto);
		mv.setViewName("loginresult");
		
		return mv;
	}*/
	
	/* 테스트1
	//로그인 요청처리
	//@RequestMapping("/loginresult")
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping("login")
	public ModelAndView bbb(HttpServletRequest request) throws Exception {
		// id,pw 요청 파라미터
		// 스프링 filter(spring mvc) - web.xml 설정
		//request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//모델로 저장
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("model",dto);
		mv.setViewName("loginresult");
		
		return mv;
	}
	*/
}
