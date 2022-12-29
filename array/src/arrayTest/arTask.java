package arrayTest;

import java.util.Iterator;
import java.util.Scanner;

public class arTask {

	public static void main(String[] args) {
//브론즈
//		1~10까지 배열에 담고 출력
		int[]arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
		System.out.println("=============================");
		
//		10~1까지 중 짝수만 배열에 담고 출력
		int []arr1= new int[5];
		for (int i = 0; i <arr1.length; i++) {
			arr1[i] = (5-i)*2;									//★★☆
				System.out.println(arr1[i]);
		}
		System.out.println("=============================");

		
		//		1~100까지 배열에 담은 후 홀수만 출력
		int[] arr2 = new int[100];
		for (int i = 0; i < 100; i++) {
			arr2[i] = i+1;
			if(arr2[i] %2==1) {
			//또는
//			if(arr[i]%2==0){
//				continue;
//			}
				System.out.println(arr2[i]);
			}
		}		
		
		//실버
//		1~100까지 배열에 담은 후 짝수의 합 출력
			int []arr3 = new int[100];
			int total = 0;
			for (int i = 0; i < arr3.length; i++) {
				arr3[i] = i+1;
					if(arr3[i]%2==0) {
						total = total+arr3[i];		//total+=arr,3[i]
					}
				}
			System.out.println(total);

			
			System.out.println("=============================");
//		A~F까지 배열에 담고 출력 65~70
			int[]arr4 = new int [6];
			for (int i = 0; i < arr4.length; i++) {
				arr4[i]=65+i;
				System.out.println((char)arr4[i]);
			}
			
//		다른풀이
//			char[]arr4 =new char[6];
//			for (int i = 0; i < arr4.length; i++) {
//				arr4[i]=(char)(65+i);
//			}
			System.out.println("=============================");
			
			
//		A~F까지 중 C 제외하고 배열에 담은 후 출력	//★★★
		int[]arr5 = new int[5];
		for (int i = 0; i < arr5.length; i++) {			//3일때 C가 아닌 D로 바뀌어야함
			arr5[i]=(i>1? 66+i : 65+i);
			System.out.println((char)arr5[i]);			
			//i가 1보다 크면 66+i
			//i=0, i<1, 	65+0=65, (char)65 = A
			//i=1, i<=1,	65+1=66, (char)66 = B	
			//	i = 67일 경우를 만들지 않으려면 삼항연산자
			//i=2, i>1,	66+2=68, (char)68 = D
			//i=3, i>1,	66+3=69, (char)69 = E	
			//i=4, i>1,	66+4=70, (char)70 = F	
		}
		
		System.out.println("=============================");
		
		//골드
//		5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
		//스캐너 선언
 		Scanner sc = new Scanner(System.in);
		//5칸의 배열
		int []arr6= new int[5];
		//최대값, 최소값 변수선언
		int max=0, min=0;
		
		//입력받은 값을 배열에 넣기 위한 반복문
		for (int i = 0; i < arr6.length; i++) {
			System.out.print("정수 5개를 입력하세요 : ");
			arr6[i]=sc.nextInt();
		}
		
		//입력값 대소비교를 위한 조건문	//★★★
		for (int i = 1; i < arr6.length; i++) {
			//
			max = arr6[0];
			min = arr6[0];		
			if(max<arr6[i]) {				//★부등호
				max = arr6[i];
			}
			if(min>arr6[i]) {				//★부등호
				min = arr6[i];
			}
		}
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+min);
		
		System.out.println("=============================");
		
		//다이아
//		사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균구하기
		//스캐너 선언
		Scanner sc1 = new Scanner(System.in);
		//배열선언
		int arr7[] = null;
		//변수선언
		int total1 = 0;
		
		//배열 칸수 입력받기
		System.out.println("정수의 개수 : ");
		arr7 = new int[sc.nextInt()];
		
		//배열에 입력값 저장하는 반복문
		for (int i = 0; i < arr7.length; i++) {
			System.out.println("정수를 입력하세요 : ");
			arr7[i] = sc.nextInt();
		}
				
		//합구하기
		for (int i = 0; i < arr7.length; i++) {
			total1 += arr7[i];
		}
		System.out.println("입력값의 평균 : "+total1/arr7.length);		
		
		}
}
