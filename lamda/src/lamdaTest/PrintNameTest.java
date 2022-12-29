package lamdaTest;

public class PrintNameTest{
//외부에서 람다식으로 구현한 값을 name으로 전달받기
	public static void printFullName(PrintName name) {	//PrintName타입의 매개변수
		      System.out.println(name.getFullName("정", "서림"));
	}

	public static void main(String[] args) {
		//매개변수 2개를 설정하고 , 두 문자열을 연결하도록 구현한다.
		
		//변모순서
//		1.		printFullName();
//		2.		printFullName((PrintName f, PrintName l) -> f+l); 	//어차피 타입은 PrintName이므로 타입생략
//									PrintName타입의 f와 l을 받아서 -> 둘이 더하면 연결된다.
//		3.
		printFullName((f , l) -> f + l);
	}

}
