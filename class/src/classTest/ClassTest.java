package classTest;

class A{
	int data;
	A(){}
	A(int data){
		System.out.println(this);			//주소
		System.out.println(this.data);	//0 : 초기화상태
		this.data= data;
		System.out.println(this.data);	//입력한 값
		//저장공간 = 값
	}
	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
	A a = new A(10);
	System.out.println(a.data);
	a.printData();
	}
}
