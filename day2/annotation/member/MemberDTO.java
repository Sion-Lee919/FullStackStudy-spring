package annotation.member;

import org.springframework.stereotype.Component;

@Component("ww2") // id=memberDTO <bean id="memberDTO" class="annotation.member.MemberDTO"/>
public class MemberDTO {
	String id;
	int pw;
	String name,phone,email, regdate;
	
	MemberDTO(){} //<bean id="dto2" class="member.MemberDTO">
	
	MemberDTO(String id, int pw){
		/*
		 <bean id="dto2" class="member.MemberDTO">
		 	<constructor-arg name="id" value="spring"/>
			<constructor-arg name="pw" value="1111"/>
			</bean>
		 */
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
