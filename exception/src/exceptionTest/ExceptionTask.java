package exceptionTest;

import java.text.NumberFormat;
import java.util.Scanner;

public class ExceptionTask {

	public static void main(String[] args) {
		//5개 정수 입력받기
		//무한 입력상태로 구현
		//q입력 시 나가기
		//5개의 정수는 배열에 담기
		//if문은 딱 한번만 사용하기
		
		Scanner sc = new Scanner(System.in);
		String user = null;
		String msg = "5개의 정수를 입력하세요(q나가기) : ";
		int []num= new int[5];
		
			int i =0;					//초기값

			//무한 입력상태 ????
			while(true){				//무한
				i++;						//while문을 for문 처럼 활용
				System.out.println(msg);
				user = sc.next();
				
				
				//q입력은 나가기(if문 한번 사용)
				if(user.equals("q")) { break; }
				
				try {
					//입력 문자 user를 정수로 변환
					num[i]=Integer.parseInt(user);
					System.out.println(num[i]);
				}catch(NumberFormatException e) {
					System.out.println("오류 : 정수를 입력하세요");
					--i;
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("오류 : 범위를 벗어났습니다.");
				}catch(Exception e) {
					System.out.println("?");
					--i;
				}
			}
		
	}
}
