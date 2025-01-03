package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

}