package collectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
		//<?>은 generic(이름이 없다)을 의미한다
		//객체화 시 타입을 지정하는 기법
		//설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용한다.
		//따로 down Casting을 할 필요가 없다. 
		//지정할 타입에 제한을 줄 수 있다	(ex.Obejct)
		
		ArrayList<Integer> datas = new ArrayList<Integer>();	//뒤의 <Integer>는 생략가능
	      datas.add(10);
	      datas.add(20);
	      datas.add(70);
	      datas.add(40);
	      datas.add(90);
	      datas.add(60);
	      datas.add(80);
	      datas.add(50);
		
//		System.out.println(datas.size());
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}
		System.out.println(datas);	//배열이 그대로 나오는이유는
		System.out.println(datas.toString());		//toString을 재정의했기 때문
		
		//Collection은 인터페이스, Collections는 클래스
		Collections.sort(datas);		//sort는 오름차순으로 정리됨, toString을 재정의했기 때문
												//재정의 : 주소에 직접접근하여 바꿨기 때문에 다른영역에서도 바뀌었다.
		System.out.println(datas);	//여기에서 정렬되어 나오는것

		//내림차순은 없으니까 
		//오름차순을 먼저하고 역순으로 해주는 reverse를 쓴다
//		Collections.sort(datas);
		Collections.reverse(datas);
		System.out.println(datas);
		
		//shuffle은 무작위로 섞는다
		Collections.shuffle(datas);
		System.out.println(datas);
		
		//래퍼 클래스
//		int a = 10;
//		Integer i = a;	//박싱
//		i=a;					//언박싱
		
		//50뒤에 500삽입(중간에 넣기)
		//내풀이
		datas.add(datas.indexOf(50)+1, 500);
		System.out.println(datas);
		
//		강사님 풀이
//		for (int i = 0; i < datas.size(); i++) {
//			if(datas.get(i)==50) {
//				datas.add(i+1,500);
//			}
//		}
//		System.out.println(datas);
		
//		//추가(삽입)
//		//50뒤에 500삽입(중간에 넣기)
//		//50값이 나오면 뒤에 500 이어주기
//		//1. 50 이 있는지 검사
//		//2. 해당 index번호를 get으로 가져오든  <<<get은 어떻게 알았지
//		//	indexOf로 가져오든 가져오기.
//		for (int i = 0; i < datas.size(); i++) {
//			if(datas.get(i)==50) {
//				datas.add(i+1, 500);
//			}
//		}
//		System.out.println(datas);
//		
////		if(datas.contains(50)) {
////			datas.add(datas.indexOf(50)+1, 500);			
////		}
//////		datas.add(4, 500);
////		System.out.println(datas);
//		
//		
//		//수정
//		//90을 9로 수정
		
		datas.set(datas.indexOf(90),9);
		System.out.println(datas);
		
//		//1. 90이 있는지 검사 
//		//2. index(순서) 찾기
//		//3. 9로 수정
//		if(datas.contains(90)) {
//			System.out.println(datas.set(datas.indexOf(90),9)+"이 수정되었습니다.");
//		}
//		System.out.println(datas);

		
		
		
//      삭제
//      80 삭제
//		1. 인덱스로 삭제
//		2. 값으로 삭제	
		
		//근데 이미 배열인데 박싱해줄 필요가 있나?
		//boxing해주면 어차피 거기 값에 접근해서 메소드 써줘야해서 unboxing해줘야하는데
		// -> 이 질문은 아예 틀렸음
		//remove메소드는 오버로딩(중복정의)이 되어있는데 
		//remove(Object obj)를 활용하려면 Object의 자식클래스인 Integer로 래핑해줘야 한다.
		
//		Object를 상속받은 클래스들은 Integer, Double등이 있는데
//		Integer 타입으로 묶어줘야 Object타입으로 업캐스팅 할 수 있으므로
//		int변수를 Integer타입으로 묶어준다
		if(datas.contains(80)) {
			datas.remove(Integer.valueOf(80));			
		}
		System.out.println(datas);
		
		
		
		
		
		
		
		
//		//삭제
//		//80삭제
//    if(datas.contains(80)) {
//      System.out.println(datas.remove(datas.indexOf(80)) + " 삭제");
//   }
//   System.out.println(datas);
//   
//   //2. 값으로 삭제
//   if(datas.remove(Integer.valueOf(80))) {
//      System.out.println("삭제 완료");
//   }
//	System.out.println(datas);	
		
	}
}
