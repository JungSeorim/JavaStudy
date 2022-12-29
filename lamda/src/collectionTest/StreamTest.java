package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;	
import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) {		
//		forEach()		//컬렉션의 반복문
//		여러개를 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
//		forEach메소드에는 Consumer인터페이스 타입의 값을 전달해야 한다.
//		Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다.
//		매개변수에는 컬렉션 객체 안에 들어가있는 값들이 순서대로 담기고,
//		화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		
		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>();
		chinaTown.put("짜장면", 4500);
		chinaTown.put("짬뽕", 5500);
		chinaTown.put("탕수육", 14500);

		
		//값(가격)만 불러오기
		//여러개의 값을 갖고있는 것은 stream타입으로 변경가능
		chinaTown.values().stream().forEach(price -> System.out.println(price));	//Consumer accept(Integer price){}
	    chinaTown.values().forEach(price -> System.out.println(price));
	    //HashMap(chinaTown)의 값(Value) 여러개를 받아와서 
	    //forEach로 저장된 Integer price를 반복하여 출력한다(println)
	    
	    //전달받은 매개변수를 그대로 메소드에 사용할 경우에는 참조형 문법(기본형을 제외한 모든)을 사용할 수 있다.
	    //소속 :: 메소드명 --> 전달받은 값을 메소드의 매개변수로 바로 전달해준다.
	    chinaTown.values().forEach(System.out::println);	// 소속 : : 메소드
	      
//	      datas.add(10);
//	      datas.add(20);
//	      datas.add(30);
//	      datas.add(40);
	      
//	      datas.forEach(value -> {
//	         System.out.println(value);
//	         System.out.println("안녕");
//	      });

		
//		IntStream.range(start,end) : start 부터 end-1까지
//		IntStream.reangeClosed(start,end) : start부터 end까지
	    //1~9까지 출력
	    IntStream.range(1, 10).forEach(System.out::println);
	    //1~10까지 출력
	    IntStream.rangeClosed(1, 10).forEach(System.out::println);
	    //일반for문 말고 범위에 있어서는 IntStream을 떠올려야한다    
	    
	    
//	    CharStream은 없다. chars()는 IntStream으로 바꿔주는 메소드
//		chars() : 문자열을 IntStream으로 변경
//	    하나씩 떼서 숫자상태로 return해준다
	    String data1 = "ABC";
	    data1.chars().forEach(System.out::println);
	    data1.chars().forEach(number -> System.out.println((char)number));
	    
	    
//		map() : 기존 값을 원하는 값으로 변경 (return값 존재)
	    String data = "ABC";
	    data.chars().map(number -> number + 3).forEach(v ->System.out.println((char)v));
	    
	    
	    
//		filter() : 리턴값이 true일 때만 수집됨, 조건식을 작성하여 false인 경우 제외시킨다
	    IntStream.rangeClosed(1,10).filter(n-> n%2==0).forEach(System.out::println);
	    
	    
	    
//	    sorted() : 배열을 arrayList로 바꿀수 있다
	    Integer[]arData= {10,20,30,40};
//	    ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(arData));
	    ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(10,20,30,40));
	    System.out.println(datas);
	    //오름차순
	    datas.stream().sorted().forEach(System.out::println);	//sorted : ArrayList -> String
	    //내림차순
	    datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	    
	    
	    
//		collect() : 결과를 다양한 타입으로 바꿔준다, 주로 마지막에 써줌
	    ArrayList<Integer> results = 
	    		(ArrayList)datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());	//collect(Collectors.toList()) : 앞에 있는걸 List로 담아서 return하겠다
	    System.out.println(results);
	    
	    
	    
//	    Collectors.joining("구분점");
//	    문자열 타입의 값을 원하는 구분점으로 연결하여 리턴한다.
//	    문자열 타입이 아닌 값은 joining을 사용할 수 없다.
	    String result2 = datas.stream().sorted().map(String :: valueOf).collect(Collectors.joining());
	    																				//valueOf로 박싱
	    System.out.println(result2);
	    
	    
	    String a = "안녕하세요";
	    System.out.println(a.substring(2,4));
	    
	}

}
