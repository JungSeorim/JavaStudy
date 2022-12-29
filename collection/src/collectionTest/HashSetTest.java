package collectionTest;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> bloodType = new HashSet<>();
		
		bloodType.add("A");
		bloodType.add("B");
		bloodType.add("O");
		bloodType.add("AB");
		bloodType.add("A");
		bloodType.add("A");
		bloodType.add("A");
		
		//똑같이 나옴 toString재정의
		System.out.println(bloodType.toString());
		System.out.println(bloodType);
		
		//Iterator<String>이라는 타입은 HashSet의 주소값(bloodType)의 iterator메소드
		Iterator<String> iter = bloodType.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
}
}
