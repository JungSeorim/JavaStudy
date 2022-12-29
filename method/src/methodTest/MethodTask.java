package methodTest;

import java.util.Iterator;

public class MethodTask {
	//1~10까지 println()으로 출력하는 메소드
		void printNum() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i+1);
			}
		}
	//"홍길동"을 n번 println()으로 출력하는 메소드
		void printHGD(int count){
			for (int i = 0; i < count; i++) {
				System.out.println("홍길동");
			}
		}
	//이름을 n번 println()으로 출력하는 메소드
		void printName(String name, int n) {
			for (int i = 0; i < n; i++) {
				System.out.println(name);
			}
		}
	//세 정수의 뺄셈을 "해주는" 메소드
		int printMinus(int num1, int num2, int num3) {
			int result = num1-num2-num3;
			return result;
		}
	
		
				
		//두 정수의 나눗셈을 "해주는" 메소드(몫과 나머지 둘 다 )
		 int[] divide(int num1, int num2){
		      int[] results = null;
		      
		      if(num2 != 0) {
		         results = new int[2];
		         
		         results[0] = num1 / num2; 
		         results[1] = num1 % num2;
		      }
		      return results;
		   }

		 
		 //<<<<<<<<<<<<<<심화문제>>>>>>>>>>>>>>>>
		 
	//   1~n까지의 합을 구해주는 메소드
		 int getTotal(int userNum) {
			 int sum=0;
			 for (int i = 0; i < userNum; i++) {
				sum += i+1;
			}
			 return sum;
		 }
		 
	//   홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
		 int changeNum(int userNum1) {
			int newNum;
			newNum=userNum1+1;
			 return newNum;
			 
			 //강사님 풀이 (한줄맞음)
//			 return ++userNum1;	
		 }
		 
		 
		 //형변환 복습 char와 String은 따로 형변환을 해주지 않았다
	//   문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
		 String printABC(String userWord) {
			 //변수 선언
			 String result = "";		//null로 초기화 x : 누적연산자 +=때문에
			 for (int j = 0; j < userWord.length(); j++) {
				 //char c = 입력받은 userWord에서 j번째 있는 문자
				 char c = userWord.charAt(j);
				 if(64 < c && c < 91) {											//대문자일때
					 result += (char)(c+32);									//형변환
				 }else if(96 < c && c < 123) {								//소문자일때	: 후위
					 result += (char)(c-32);
				}else {
//					changeWord = changeWord+c;						//문자를 이어출력하면 String으로 형변환
					result +=c;
				}
			}
			 return result;	
		 }
	
		 
	//다시풀기	 
	//다시풀기 완료
	//   문자열을 입력받고 "원하는 문자"의 개수를 구해주는 메소드
		 int numCount(String str, char a) {
			 int countedNum = 0;
			 //반복문으로 하나씩검사하기
			 for (int i = 0; i < str.length(); i++) {
				if(a==str.charAt(i)) {
					countedNum++;
				}
			}return countedNum;
		 }
		 
		 
	//   5개의 정수를 입력받은 후 원하는 번째값을 구해주는 메소드
		 int countNum(int []arNum, int wantedNumber) {
			 //5개의 정수를 배열로 입력받음 (매개변수를 int num1~num5하나씩하면, 선언도 귀찮고 관리도 어려움)
			 //index는 0부터시작하므로 다른 것으로 해주기
			 //변수선언 (반환값)
			 int result =0;
			 for (int j = 0; j < 5; j++) {
//				arNum[j] 되어있는 상태
				result = arNum[wantedNumber]; 
			 }				
			 return result;
			}
		 //강사님 풀이 (한줄 맞음)
		 //return nums[wantedNumber - 1];
		 
		 
	//   한글을 '정수'로 바꿔주는 메소드
		 String changeHG(String HG) {
			 String strr = "공일이삼사오육칠팔구",result ="";
			 for (int i = 0; i < HG.length(); i++) {
				result+=strr.indexOf(HG.charAt(i));
			 }
			 return result;
		 }
		 
		 
//		 String changeHG(String HG) {
//			 //변수 선언
//			 String arStr = "공일이삼사오육칠팔구",result ="";
//			 //반복문
//			 for (int i = 0; i < HG.length() ; i++) {
//				 result += arStr.indexOf(HG.charAt(i));	// 정수로 변환해준 = 입력한 값의 i번째 문자의 순서
//			 	}
//			 return result;
//			}
		 
		 
		 
	//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
			 int[] getMaxAndMin(int[] nums) {
			 //변수 선언
			 int max=nums[0];
			 int min=nums[1];
			 
			 //return값선언
			 int [] result = new int[2];
			result[0]=max;
			result[1]=min;
			
			//반복문
			for (int i = 0; i < nums.length; i++) {
				//max 4  <   0, 1 ,2 
				if(result[0] < nums[i]) {		//i번째보다 큰값이 없으니까
					result[0]=nums[i];
				}
				//min
				if(result[1] > nums[i]) {
					result[1] = nums[i];
				}
			}
			return result;
		 }
		
		
		//   어려움★★★★★
		//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다)
		//   매개변수는 2개 전달해야 한다.
			 void getMinAndMin(int []nums, int []result) {
				 //변수 선언 nums는 2칸.
				 int max=nums[0];
				 int min=nums[1];
				 
				 //return값선언
				result[0]=max;
				result[1]=min;
				
				//반복문
				for (int i = 0; i < nums.length; i++) {
					//max
					if(result[0] < nums[i]) {
						result[0]=nums[i];
					}
					//min
					if(result[1] > nums[i]) {
						result[1] = nums[i];
					}
				}
			 }
			 
			 
	public static void main(String[] args) {
		MethodTask mt = new MethodTask();
		//기본실습 (강사풀이)
//      mt.printFrom1To10();
//      mt.printHong(10);
//      mt.printName("한동석", 10);
//      System.out.println(mt.substract(5, 4, 2));
//      int[] results = mt.divide(10, 3);
//      String msg = null;
//      msg = results == null ? "0으로 나눌 수 없습니다." : "몫 : " + results[0] + "\n나머지 : " + results[1];
//      System.out.println(msg);

		
		
		
		//심화실습 (내풀이)
		System.out.println(mt.getTotal(5));
		System.out.println(mt.changeNum(43));
		System.out.println(mt.printABC("dE2fsa3"));
		//공란 ; 다시 해보기
		System.out.println(mt.numCount("dfafsdffa", 'f'));
		System.out.println(mt.countNum(new int[] {3,44,25,111,6}, 3));
		System.out.println(mt.changeHG("육이칠구삼이일"));
		System.out.println(mt.getMaxAndMin(new int[] {4,5}));
		
		
		//심화실습 실행(강사풀이)
//      1~n까지의 합을 구해주는 메소드
//      int getTotalFrom1(int end)
//      System.out.println(mt.getTotalFrom1(10));
      
//      홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//      int change(int number)
//      boolean result = mt.change(11) % 2 == 0;
//      System.out.println(result ? "홀수에서 짝수로 바뀌었습니다." : "짝수에서 홀수로 바뀌었습니다.");
      
//      문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//      String changeString(String string)
//      System.out.println(mt.changeString("aPplE1234!@#$"));
   
//      문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//      int getCount(String string, char c)
//      System.out.println(mt.getCount("apple", 'p') + "개");
      
//      5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
//      int getValue(int[] nums, int wantedNumber)
//      int[] arData = {1, 2, 5, 7, 8};
//      System.out.println(mt.getValue(arData, 3));
      
//      한글을 정수로 바꿔주는 메소드
//      int changeToInteger(String hangle)
//      int result = mt.changeToInteger("삼공오이사");
//      System.out.println(result - 3);
      
//      5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드

		//      void getMaxAndMin(int[] nums, int[] results)
//      int[] arData = {1, 2, 5, 7, 8};
//      int[] results = new int[2]; 
//      mt.getMaxAndMin(arData, results);
//      
//      System.out.println("최대값 : " + results[0]);
//      System.out.println("최소값 : " + results[1]);
	}

}
