package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
	//커플링(결합도) 낮추기
		//외부 TV객체 전달받는다/직접 TV객체 생성하지 않는다(INVERSION OF CONTROL)
		//TVFactory는 TV객체 직접 생성한다. 외부로 전달한다.(CONTROL)
		//spring tv.xml 설정에 있는 객체 생성 요청
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		//TV tv = (TV)factory.getBean("tv");
		TV tv = factory.getBean("tv",TV.class);
		if(tv !=null) {
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		}
		else {
			System.out.println("우리 공장에서 취급하지 않는 브랜드입니다");
		}
		TV tv1 = factory.getBean("tv",TV.class);
		TV tv2 = factory.getBean("tv",TV.class);
		TV tv3 = factory.getBean("tv",TV.class);
		
	}

}
