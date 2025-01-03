package annotation.springmvc;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	HashMap<String, Integer> moviemap = new HashMap(); 
	@GetMapping("/movielist")
	public ModelAndView start() {
		moviemap.put("영화제목1", 19); 
		moviemap.put("영화제목2", 13); 
		moviemap.put("영화제목3", 19); 
		moviemap.put("영화제목4", 0); 
		moviemap.put("영화제목5", 10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("mo",moviemap);
		mv.setViewName("movielist");
		return mv; 
	}
	
	@PostMapping("/moviereserve")
	public ModelAndView end(@ModelAttribute("mov") MovieDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("moviereserve");
		
		return mv;
	}
}
