package classTest;

import java.util.Iterator;

class Test{
	int data;

	// 	 ; 의미  = "일부로 비워놓은것"
	public Test() {;}		//기본생성자 = 메모리 할당
	
	public Test(int data) {
		super();
		this.data = data;
	}
	
	void printData() {
		System.out.println(data);
	}
	
}


public class ClassArray {

	public static void main(String[] args) {
		Test [] arA = new Test[12];
		
		for (int i = 0; i < arA.length; i++) {
			arA[i]=new Test(i+1);	//매개변수 생성자에 숫자를 넣음
			System.out.println(arA[i].data);
		}

				
	}

}
