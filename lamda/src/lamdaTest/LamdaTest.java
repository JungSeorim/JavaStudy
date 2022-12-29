package lamdaTest;

public class LamdaTest {

	public static void main(String[] args) {
		//주석처리부분(객체생성과 익명클래스선언)을 한줄로 변경한 람다식
//		LamdaInter lamdaInter1 = new LamdaInter() {
//			@Override
//			public boolean checkMultipleOf10(int num) {
//				return false;
//			}
//		};
		
		//어차피 메소드는 하나니까 메소드명과 변수 타입을 받아오지 않아도 된다.
		LamdaInter lamdaInter1 = (num)->num%10==0;	
		boolean result1 =  lamdaInter1.checkMultipleOf10(3);
		System.out.println(result1);
		
	}
	

}
