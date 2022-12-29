package collectionTask;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Page {
	//main메소드
	//테스트진행
	public static void main(String[] args) {
		String menu="1. 회원가입 \n2. 로그인\n3. 비밀번호 찾기(인증번호, 비밀번호 변경)\n4. 나가기",
				nameMsg = "이름을 입력하세요 : ", idMsg = "아이디를 입력하세요 : ", pwMsg = "비밀번호를 입력하세요 : ", phoneMsg="폰번호를 입력하세요 : ";
		ArrayList<User> userData = new ArrayList<>();

		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		User user = null;
		
		while(true) {
			System.out.println("🎀페이지🎀");
			System.out.println(menu);
			choice = sc.nextInt();
			
			if(choice==4) {break;}
			
			switch(choice) {
			case 1:
				System.out.println("[회원가입]");
				//모두 User타입으로 저장한다면
				//ArrayList에는 언제 넣는 것?
				//하나씩 추가할거면 왜 add메소드와
				//UserField의 signUp메소드를 만들어줬을까
				
				System.out.println(nameMsg);
				String userName = sc.next();
//				UserField.userData.add(user.setName(userName));	//오류
//				user.setId(userName);
				
				System.out.println(idMsg);
				String userID =sc.next();				
				//아이디 중복체크
				//입력한 값과 저장된 값이 중복되는게 있다면
				if(UserField.checkID(userID)!=null) { break; }		//멈추고 중복값 return					
				//없다면 set
//				UserField.userData.add(user.setId(userID));
//				user.setId(userID);
				
				System.out.println(pwMsg);
				String userPW =sc.next();
//				UserField.userData.add(user.setPw(userPW));
//				user.setPw(userPW);
				
				System.out.println(phoneMsg);
				String userPhone = sc.next();
//				UserField.userData.add(user.setPhone(userPhone));
//				user.setPhone(userPhone);

//				UserField.signUp(userName, userID, userPW, userPhone);
				//user= null 이어서 오류떴음
				System.out.println("회원가입 완료!");
			
			}break;
		}
	}

}
