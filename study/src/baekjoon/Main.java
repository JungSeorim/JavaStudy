package baekjoon;

import java.util.Scanner;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
//		갖고 있는 체스 개수 입력받기
        Scanner sc = new Scanner(System.in);
        int[] Dongjun = new int[6];
        for (int i = 0; i < Dongjun.length; i++) {
        	Dongjun[i] = sc.nextInt();
        }
		//원래 있어야하는 말 개수
		int []originalCount= new int[]{1, 1, 2, 2, 2, 8};
		
		int num = 0;
		for (int i = 0; i < Dongjun.length; i++) {
				num = originalCount[i]-Dongjun[i];
				System.out.println(num);
		}
		sc.close();
	}
}
