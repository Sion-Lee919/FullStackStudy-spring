package interceptortest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[preHandle] " + request + ":" + request.getMethod()+ ":"+request.getRequestURI());
		System.out.println("[preHandle] " + handler.toString());
		
		/*
		if(request.getSession().getAttribute("sessionid")!=null && request.getSession().getAttribute("sessionid").equals("admin")) {
			return true;
		}
		else {
		return false;
		}
		*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null) {
		System.out.println("[postHandle] 모델이름" + modelAndView.getModel()+", 뷰이름=" + modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");

	}

}
