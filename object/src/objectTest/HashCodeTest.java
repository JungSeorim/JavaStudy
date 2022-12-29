package objectTest;

import java.util.Random;

public class HashCodeTest {

	public static void main(String[] args) {
		
		//다른 컴퓨터에서도 같은 64578이 출력되는데
		//이는 hashCode에서 같은 JVM에서 관리하기 때문
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		//String에서 hashCode도 재정의했기 때문에
		//준비주소가 같게 나온다
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		
//		Random r1 = new Random();
//		Random r2 = new Random();
//		System.out.println(r1.hashCode());
//		System.out.println(r2.hashCode());

}
}
