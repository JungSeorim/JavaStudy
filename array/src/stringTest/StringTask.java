package stringTest;

import java.util.Scanner;

public class StringTask {

	public static void main(String[] args) {
		//사용자에게 입력받은 문자열 중 소문자는 모두 대문자로, 
		//대문자는 모두 소문자로 변경한다.
		Scanner sc = new Scanner(System.in);
		String msg = "대소문자 변환 : ", result ="";

		//입력받기
		System.out.println(msg);
		String user = sc.next();
		
		//입력받은 문자열을 모두 대소문자로 변환해주려면 
		//문자열이 끝날때까지 반복하여 하나씩 대소문자로 변환
		for (int i = 0; i < user.length(); i++) {
			
			//i번째 문자(1개)를 추출하여 (숫자변환 필요없음)
			char word = user.charAt(i);

			//if문으로 대소문자인지 구분후 대소문자 변환			
				if(64<word &&word<91) {
					//1번째 문자에 32(정수)를 더해주면 정수, 정수에 (char)형변환 해주면 다시 char(문자). 
					//문자열(String)로 바꿔주려면 result를 그냥 더하면됨 (초기값이 "") 
					//정리
					result += (char)(word+32);				//+=을 해줘야 String으로 바뀜
				}else if(97<word && word<122) {
					result += (char)(word-32);						
				}else {
					result+=word;
				}
		}
		System.out.println(result);
		
		
		
		
		
		//정수를 한글로 변경
		//예) 1024 ->일공이사
		
		//방법1 : 정수로 입력받기
		//스캐너
		Scanner sc1 = new Scanner(System.in);
		//변수선언 (입력받을 정수)
		int num =0;
		String hangle = "공일이삼사오육칠팔구", result1="";
		
		String msg2 = "정수 : ";
		System.out.println(msg2);
		num = sc.nextInt();
		
		while(num!=0) {												//while문 사용 (몫이 있는동안 반복하겠다)
//			result += hangle.charAt(num%10);				//아래의 정방향
			result1 = hangle.charAt(num%10)+result1;		//charAt(i번째 인덱스에있는 문자열 불러옴), 역순으로 입력해줌
			num /= 10;													//10으로 나눠주면
		}System.out.println(result1);
		
		
		//방법2 : 문자열로 입력받기
//	      Scanner sc = new Scanner(System.in);
//	      String msg = "정수 : ", hangle = "공일이삼사오육칠팔구", result = "", number = null;
//	      
//	      System.out.print(msg);
//	      number = sc.next();
//	      
//	      for (int i = 0; i < number.length(); i++) {
//	         result += hangle.charAt(number.charAt(i) - 48);
//	      }
//	      
//	      System.out.println(result);
	      

	}
}
