 package mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MenberMain {

	public static void main(String[] args) throws IOException ,SQLException{
		// 1. mybatis/mybatis-config.xml 파일 읽어라
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		//SqlSession session = factory.openSession();//수동 커밋롤백
		//SqlSession session = factory.openSession(false);//수동 커밋롤백
		SqlSession session = factory.openSession(true);//자동커밋
		System.out.println(session.getConnection().getAutoCommit());
		
		/*
		List<MemberDTO> list = session.selectList("a.memberList");//a. b. memberList
		for(MemberDTO dto : list) {
			System.out.println(dto.getId()+ " : " + dto.getName()+ " : "+ dto.getEmail());
		}*/
		
		/*
		MemberDTO dto = session.selectOne("oneMember","q1");
		System.out.println(dto.getId()+ " : " + dto.getName());
		*/
		/*
		int count = session.selectOne("memberCount");
		System.out.println("전체회원수=" + count);
		*/
		
		/*int rows = session.insert("insertMember");
		System.out.println("가입한 회원수=" + rows);
		//session.commit();*/
		
		/*MemberDTO dto = new MemberDTO();
		dto.setId("mybatis4");
		dto.setName("박길동");
		dto.setPw(4444);
		dto.setPhone("010-1122-3344");
		dto.setEmail("ss@nn.com");		
		int rows = session.insert("insertMemberDTO",dto);
		System.out.println("가입한 회원수=" + rows);*/
		
		/*
		MemberDTO dto = new MemberDTO();
		dto.setId("mybatis4");
		dto.setName("박길동");
		dto.setPw(44444);
		dto.setPhone("010-1332-3344");
		dto.setEmail("s1s@n1n.com");		
		int rows = session.insert("updateMember",dto);
		System.out.println("수정한 회원수=" + rows);*/
		
		/*
		session.delete("deleteMember","mybatis4");*/
	}

}
