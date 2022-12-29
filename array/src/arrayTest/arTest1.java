package arrayTest;

import java.util.Iterator;

public class arTest1 {

	public static void main(String[] args) {
		int [] arData = {2,4,5,6,7};	//Heap메모리에 할당(new 생략됨)
		System.out.println(arData);	//주소나옴: [I@182decdb <<< [로 시작하면 배열의 주소값
		System.out.println(arData.length);
		System.out.println(arData[0]+7);
		
		System.out.println(arData[0]+7);
		System.out.println(arData[1]);
		System.out.println(arData[2]);
		System.out.println(arData[3]);
		System.out.println(arData[4]);		//몇번 반복할지 아니까 for문 사용
		
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
		
		//5,4,3,2,1을 넣고 출력
		for (int i = 0; i < arData.length; i++) {
			arData[i] = 5-i;
			System.out.println(arData[i]);
		}
	}
		
}