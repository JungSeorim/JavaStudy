package arrayTest;

public class arrTest {

	public static void main(String[] args) {				//의,면,행,열
		int [][] arrData = {{3,4,5,6},{8,9,0,9},{1,2,3,4}}; 		//3행 4열
		for (int i = 0; i < arrData.length; i++) {				//행에 접근 (3번반복)
			for (int j = 0; j < arrData[i].length; j++) {		//열에 접근 (4번반복)
				System.out.println(arrData[i][j]);
			}
		}
		
//		int length = arrData.length * arrData[0].length;
//		for (int i = 0; i < length; i++) {					//변수가 
//			System.out.println(arrData[i/4][i%4]);		//[행][열]
//		}
//		System.out.println(arrData.length);
//		System.out.println(arrData[0].length);

		
	}
}
