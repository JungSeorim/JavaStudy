package inheritanceTest;

class Human{
	void eat() {
		System.out.println("먹기");
	}
	
	void sleep() {
		System.out.println("자기");
	}
	
	void walk() {
		System.out.println("두 발로 걷기");
	}
}

class Monkey extends Human{
	void 이잡아라() {
		System.out.println("이잡기");
	}

	//super.walk()단축키 : w+Ctrl+space
	@Override
	void walk() {
		//부모의 코드를 그대로 사용하면서
		//코드 몇줄만 추가할 때
		super.walk();		// 부모클래스명.메소드()
		System.out.println("네 발로 걷기");	
	}
	
//	@Override		//@ : 어노테이션
//	void walk() {
//		System.out.println("네 발 또는 두 발로 걷기");
//	}

}

public class InteritanceTest2 {
	
	public static void main(String[] args) {
		Monkey kingkong =new Monkey();
		kingkong.walk();
}
}
