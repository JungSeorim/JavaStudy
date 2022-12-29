package collectionTask;

import java.util.ArrayList;

//User가 입력하는 값을 저장할 클래스

public class User {
	
//	-이름, 아이디, 비밀번호, 휴대폰번호 = String
//추가로 ArrayList넣음
//	-private으로 선언 = getter setter
//	-기본생성자만 선언
//	-toString() 재정의
	
	private String name;
	private String id;
	private String pw;
	private String phone;
	
	public User(){}
	
	//toString 재정의
	@Override
	public String toString() {
		return name+","+id+","+phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
