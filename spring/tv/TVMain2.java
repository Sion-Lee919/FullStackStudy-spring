package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain2 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv;
		tv = factory.getBean("tv1",TV.class);
		tv = factory.getBean("tv2",TV.class);
		if(tv !=null) {
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		}
		else {
			System.out.println("우리 공장에서 취급하지 않는 브랜드입니다");
		}
	}

}
