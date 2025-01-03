package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@RequestMapping("/list")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<HelloDTO> list = new ArrayList();
		list.add(new HelloDTO("모델1"));
		list.add(new HelloDTO("모델2"));
		list.add(new HelloDTO("모델3"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("list");
		return mv;
	}

	
		
	/*@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HelloDTO> list = new ArrayList();
		list.add(new HelloDTO("모델1"));
		list.add(new HelloDTO("모델2"));
		list.add(new HelloDTO("모델3"));
		request.setAttribute("list",list);
		return "list.jsp";
	}
*/
}
