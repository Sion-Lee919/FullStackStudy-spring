package aop1;

import java.util.ArrayList;

public class Board {
	public void insert(int seq) {
		System.out.println(seq + " 번째의 게시물을 작성합니다");
	}
	
	public ArrayList<String> getList(){
		ArrayList<String> list = new ArrayList();
		list.add("게시물1");
		list.add("게시물2");
		list.add("게시물3");
		list.add("게시물4");
		list.add("게시물5");
		return list;
	}
}
