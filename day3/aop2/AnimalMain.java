package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop2/aop2.xml");
		Animal animals[] = new Animal[3];
		/*
		animals[0]= factory.getBean("cat",Animal.class);
		animals[1]= factory.getBean("rabbit",Animal.class);
		animals[2]= factory.getBean("dog",Animal.class);				

		for (Animal animal : animals) {
			animal.lunch();
		}
		*/
		//인터페이스가 아니라 원래 타입으로 사용하겠다 aop2.xml - <aop:config proxy-target-class="true">로 만들고 써야함
		animals[0]= factory.getBean("cat",Cat.class);
		animals[1]= factory.getBean("rabbit",Rabbit.class);
		animals[2]= factory.getBean("dog",Dog.class);
		
		for (Animal animal : animals) {
			animal.lunch();
		}

	}

}
