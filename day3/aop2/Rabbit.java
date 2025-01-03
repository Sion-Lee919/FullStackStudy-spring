package aop2;

public class Rabbit implements Animal{
	
	public String lunch() {
		System.out.println("풀먹었습니다");
		return "Rabbit-풀";
	}
}
