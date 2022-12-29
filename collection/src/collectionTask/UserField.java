package collectionTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
	//회원정보를 담을 ArrayList선언
	//여러 회원의 정보를 담을 때 
	// * ArrayList는 번호로 관리하고 ArrayList.
	// * 클래스는 이름으로 관리한다 class.name
	//그러므로 User타입을 받는 ArrayList를 선언한다 
	public static ArrayList<User> userData = new ArrayList<>();
	
	Random r = new Random();
	
	//아이디 중복검사 : 아이디가 있다면 그 회원 전체정보를 리턴해야한다
	public static User checkID(String id) {
		User user = null;
		//userData에 저장된 값을 검사해서
		for (int i = 0; i < userData.size(); i++) {
			//입력한 id값과 일치하는 userData의 id값이 존재한다면
			if(user.getId().equals(id)) {
				//그 값을 반환해라
				return user;
			}
		}
		return null;
		}

	//-회원가입
	//입력한 정보의 값으로 초기화 하고 
	//초기화필드 주소를 arrayList에 담기
	public void signUp(User user) {		//암호화된 비밀번호를 DB에 저장
																		//setter 주소에 직접접근
	}
	
	//-로그인
	public User login(String id, String pw) {
		//아이디를 먼저확인한다
		//user에다가 넣어준 이유는 리턴값이 user정보이기 때문
		User user = checkID(id);  	
		if(user!=null) {								//(한번더 검사)
			if(user.getPw().equals(pw)) {
				return user;							//pw까지 불러와서 일치하는지 검사				
			}
		}
		return null;			//일치하지 않는다면 null
	}
	
	//	-암호화(비밀번호 아스키코드로 암호화)
	public String encrypt(String pw) {
		String encryptedPw="";
		final int KEY = 3;
		
		for (int i = 0; i < pw.length(); i++) {
			encryptedPw += (char)(pw.charAt(i)*KEY);
		}
		return encryptedPw;
	}
	
	//비밀번호 찾을때 암호풀기
	public String decrypt(String encryptedPw) {		
		String decryptedPw="";
		final int KEY = 3;
		for (int i = 0; i < encryptedPw.length(); i++) {
			decryptedPw += (char)(encryptedPw.charAt(i)/KEY);
		}
		return decryptedPw;
	}

	//	-비밀번호 변경(비밀번호 찾기 서비스) 문자api (로그인 안된 상태)
	public void changePW(User user, String newPw) {
		//매개변수 User user에는 이미 확인한 아이디, 폰번호가 담겨있어야한다
		User originalUser = checkID(user.getId());			//DB조회용
		originalUser.setPw(newPw);
	}
	
	
	//-인증번호 전송(6자리) (새로운 비밀번호 생성)
	//전달한 인증번호와 사용자가 입력한 인증번호를 비교한다(page에서 구현)
	//return값이 String인 이유 : 인증번호를 기억해야 하기때문
	public String sendSMS(String phone) {
		//비교하여 true일 경우 비밀번호 변경메소드를 사용하여 변경해준다.
		String api_key = "NCSSQALEHXOLD0TP";
	    String api_secret = "XLSKKX4TOMXQ2BHKLOFTHWXHHLEDBXJZ";
	    Message coolsms = new Message(api_key, api_secret);
	   
	    //인증번호 6자리
	    String verificationNum = "";
	    for (int i = 0; i < 6; i++) {
			verificationNum += r.nextInt(9);
		}
	    
	    //인증번호 6자리ver.2
//	    number = r.nextInt(10000000);
//	    for (int i = 0; i < 6-number.length; i++) {
//			number = "0"+number;
//		}
	    
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phone);		//입력한 폰번호
	    params.put("from", " ");
	    params.put("type", "SMS");
	    params.put("text", "[Web발신]\n인증번호 : "+verificationNum);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	 return verificationNum; 
	}
	}