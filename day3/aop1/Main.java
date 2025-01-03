package aop1;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop1/aop1.xml");
		Member member =factory.getBean("member", Member.class);
		System.out.println("==========================");
		member.login("aoptest");
		System.out.println("==========================");
		
		
		System.out.println("==========================");
		member.logout();
		System.out.println("==========================");
		
		Board board =factory.getBean("board", Board.class);
		System.out.println("==========================");
		board.insert(6);
		System.out.println("==========================");
		
		System.out.println("==========================");
		board.getList();
		
		System.out.println("==========================");
	}

}
