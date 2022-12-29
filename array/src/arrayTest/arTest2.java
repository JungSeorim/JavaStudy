package arrayTest;

public class arTest2 {

	public static void main(String[] args) {
		int []arData = new int[10];
		//1~10넣고 출력
		for (int i = 0; i < arData.length; i++) {
			arData[i] = i+1;
		}
		//목적에 맞게 끔 나누려고 syso를 다른 for문에 넣어주었다
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
	}

}
