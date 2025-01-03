package aop1;

public class Member {
	void login(String id) {
		System.out.println(id + "회원님이 로그인하셨습니다.");
	}
	
	public void logout() {
		System.out.println("로그아웃 하셨습니다");
	}
}
