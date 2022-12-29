package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
//제네릭은 개수 제한이 없다
	public static void main(String[] args) {
		//회원의 정보를 담는다
		HashMap<String, Object> userMap = new HashMap<String,Object>();
		
		//컬렉션은 부모클래스의 add메소드를 썼다
		//Map은 put메소드
		userMap.put("id", "jsr1234");
		userMap.put("pw", "1234");
		userMap.put("name", "정서림");
		userMap.put("age", 20);
		
		System.out.println(userMap.size());	//1쌍 = 1개
		System.out.println(userMap);
		System.out.println(userMap.get("id"));
		
		//한 쌍씩 분리해서 가져오기
		Iterator<Entry<String,Object>>iter = userMap.entrySet().iterator();
																				//한쌍씩	//순서붙여주기
		while(iter.hasNext()) {
			Entry<String,Object>entry = iter.next();
			System.out.println(entry.getKey() + ": "+entry.getValue());
		}
		
		
		//key값 분리하기
		 Iterator<String> iter2 = userMap.keySet().iterator();
	      while(iter2.hasNext()) {
	         System.out.println(iter2.next());
	      }
	      

	      //Value 분리하기
	      for (Object value : userMap.values()) {
	         System.out.println(value);
	      }
	}

}
