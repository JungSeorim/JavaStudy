package classTest;

import java.util.Random;

public class Animal {
	//이름(동물), 나이, 먹이, 먹이개수, 생명 (5개의 필드)	
	String name;
	int age=0;
	String feed;
	int feedCount;
	int life = 0;
	
	//기본생성자
	Animal(){}
	
	//매개변수 생성자
	public Animal(String name, int age, String feed, int feedCount, int life) {
		super();
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}
	
	//먹기 (무엇을 먹는지 필요없음, 먹음으로 인해 어떻게 되는지만)
	void eat() {
		//먹이 1개 = 생명 1 회복 = 먹이개수 1개 삭제
		feedCount--;
		life++;
	}

	//n초 동안 자기
	void sleep() {life++;}
		
	
	//산책하기
	Quiz walk(Quiz[]qzAr) {				//quiz를 외부에서 입력받아
		//하자마자 life 1 감소
		life--;
		//외부에서main 문제(qzAr)를 받아와서 하나를 골라 return해준후
		Random rd = new Random();
		
		
		//잭팟문제, 확률은 10%
		//확률이 10단위라면 10칸 배열을, 1단위라면 100칸 배열을 선언한다.
		//int배열로 선언한뒤 사용자가 원하는 확률만큼 1로 값을 바꿔준다.
		
		//예) 30%확률이라면 10칸 배열중 아무3개?의 값만 1로 바꿔준다.
		//따라서 원하는 확률 / 10 을 하여 반복횟수를 결정해주고
		//그 만큼 1이 들어가게된다.
		
		//위의 배열이 완성되었으면 랜덤한 인덱스번호로 값에 접근하여
		//1이 나왔을 때에는 원하는 경우로 성공한 것이고,
		//0이 나왔을 때에는 실패한것이다
		Quiz quiz = null;
		int []percent = new int[10];
		int rating=10;	//10%
		
		for (int i = 0; i < rating/10; i++) {
			percent[i]=1;	// "rating/10"개만 1을 넣기
		}
		
		//percent[랜덤index] == 1
		if(percent[rd.nextInt(percent.length)]==1) {	//대박문제 당첨
			for (int i = 0; i < qzAr.length; i++) {			//4번 반복하여 
				if(qzAr[i].jackpot) {	//.jackpot이 true인 것만 가져오기 (잭팟문제가 여러개여도 상관없음)
						return qzAr[i];		//잭팟문제 리턴
				}
			}
		}

		while(true){
			quiz=qzAr[rd.nextInt(qzAr.length)];
//			quiz=qzAr[(퀴즈배열 객체 순번 중) random순번];
			return quiz;
		}
	}		
	
	
	
}