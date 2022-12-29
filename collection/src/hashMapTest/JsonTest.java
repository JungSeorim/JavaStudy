package hashMapTest;

import java.awt.desktop.UserSessionEvent;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String,Object>();
		JSONObject userJSON = null;
	      JSONArray users = new JSONArray();
		userMap.put("id", "jsr1234");
		userMap.put("pw", "1234");
		userMap.put("name", "정서림");
		userMap.put("age", 20);
		
		//json에 맵을 넣어주면 알아서 JSON으로 바뀜
		userJSON = new JSONObject(userMap);
	     users.add(userJSON);
	      
	      System.out.println(users.toJSONString());
	      
	      System.out.println(((JSONObject)users.get(1)).toJSONString());
	      
		}

}
