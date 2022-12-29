package methodTest;

public class MethodTest {
	//두 정수의 곱셈 메소드 선언
	int multiple(int num1, int num2) {			//static: 을 붙이면 오류 사라짐
		return num1 * num2;
	}
	
	//static
	//컴파일러가 가장 먼저 메모리에 할당해준다.
	//일반 메소드를 static 메소드에서 사용하기 위해서는
	//1. static 을 부텽서 같이 메모리에 올려준다.
	//2. 일반 메소드의 메모리의 소속을 알려준다.
	//	-staitc메소드에서 사용된 일반메소드는 Heap영역에서 찾는다.
	//탑 클래스 타입의 변수를 선언할 때 Heap 영역에 할당되므로,
	//일반메소드도 해당변수를 통해 접근하여 사용할 수 있다.
	public static void main(String[] args) {	//static : 메모리에 먼저 할당됨
		MethodTest mt = new MethodTest();
		int result = mt.multiple(3, 6);									//multiple의 소속을 정확히 알려준다
		System.out.println(result);
	}

}
