package aop2;

public class Dog implements Animal{

	public String lunch() {
		System.out.println("사료먹었습니다");
		return "Dog-사료";
	}
}
