package collectionTest;

public class ForEachTest {

	public static void main(String[] args) {
		int [][]arrData = {{10,30,80,},{20,40,10}};
		
		//각 학생의 총점과 평균 출력
		//총점
		int total=0;
		double average = 0;
		
		for (int[] arData : arrData) {			//1차원
			total=0;	//int 빼고
			for (int score : arData) {
				total+=score;
			}average = total/(double)arData.length;		//여기가 arData인 것
			System.out.println("개인총점 : "+total);
		}
		System.out.println("2명 총점 : "+total);
		System.out.println(average);
	}

}
