package annotation.memberService;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/memberService/member.xml");
		int month = Calendar.getInstance().get(Calendar.MONTH);
		MemberService service = null;
		if(month == 0 || month ==5 || month == 11) {
			service = factory.getBean("pointservice",MemberService.class);
		}
		else {
			service = factory.getBean("basicservice",MemberService.class);
			
		}
		service.registerMember();
		
		if(service instanceof MemberPointService) {
		System.out.println("point = "+((MemberPointService)service).dao2.point + " 입니다.");
		}
	}

}
