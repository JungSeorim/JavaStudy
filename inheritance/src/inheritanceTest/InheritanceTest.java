package inheritanceTest;

class A{
	String name = "A";
	int data = 10;
	
	void printName() {
		System.out.println(name);	//this생략
	}
}

class B extends A{
	
	//찾아도 필드가 선언된 것이 없는 경우 부모클래스를 확인한다
	public B() {
		super();		//생략되어있음, super는 부모클래스 이름임, 먼저 선언
		name = "B";							//this생략
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
		B b= new B();
		b.printName();	//A클래스의 필드는 super로 자동할당되어있음
		b.printData();
	}
}
