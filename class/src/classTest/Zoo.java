package classTest;

import java.util.Random;
import java.util.Scanner;


public class Zoo {

	public static void main(String[] args) {
	
		
		//class 배열 생성(동물정보 배열 생성)
		Animal[] animals= {
				new Animal("코끼리", 120, "풀",  2, 100),
				new Animal("토끼", 3, "당근", 8, 2),
				new Animal("타조", 5, "지렁이", 5, 5)
		};
		
	     Quiz[] qzAr = {
	             new Quiz("Q. 바나나를 엄마가 사왔어요!\n형이 3개 먹고 내가 5개를 먹었더니 한 개가 남았어요.\n엄마가 사온 바나나는 총 몇 개였을까요?", "9", 10),
	             new Quiz("Q. 다음 어린이 중 누가 착한 행동을 했을까요?\n1. 요구르트를 훔친 철수\n2. 친구를 바닥에 눕힌 영희\n3. 늦게왔으면서 수업에 딴짓까지 해버리는 동석\n4. 엄마 어깨를 안마해주는 유리", "4", 2),
	             new Quiz("Q. 횡단보도를 건널 수 있는 방법을 고르세요.\n1. 빨간불일 때 건넌다.\n2. 뛰어간다\n3. 손을 들고 초록불에 건넌다.\n4. 핸드폰을 보면서 건넌다.", "3", 5),
	             new Quiz("Q. 다음중 프로그래밍 언어가 아닌것은?\n1.JAVA\n2. 파이썬\n3.망둥어\n4.C언어", "3", 3000, true) //잭팟문제를 구분해주기위해 boolean jackpot을 썼고
	     };																																													//확률은 Animal walk()에서 선언해줬음

	     Scanner sc= new Scanner(System.in);
	     
	     
	     
	     
	     
	     
	     
	     
	     System.out.println("게임시작");
	     
	     
	     
	     String title = "★모여라 셀럽동물★";
	     String menuMsg = "안녕하세요 어린이 여러분! \n 동물친구를 선택해보세요! \n1. 코끼리\n2. 토끼\n3. 타조\n4. 내정보\n5. 나가기";
	     String actionMsg = "1.먹기\n2.잠자기\n3.산책하기\n4.작별인사하기";
	    
	     int characterNumber = 0, actionChoice=0;	//입력받은 동물친구 번호(index+1)
	     
	     while(true) {
	    	 System.out.println(title);
	    	 System.out.println(menuMsg);
	    	 characterNumber = sc.nextInt();
	    	 if(characterNumber==5) {
	    		 break;
	    	 }
	    	 while(true) {
	    		 System.out.println(actionMsg);
	    		 actionChoice = sc.nextInt();	    				 
	    		 if(actionChoice==4) {
	    			 break;																//두번 나가야(break) 게임종료
	    		 }
	    		 
	    		 Animal animal = animals[characterNumber-1];	//characterNumber-1 : 인덱스 번호를 바꿔주기
	    		 
	    		 switch(actionChoice) {
	    		 case 1 : //먹기
	    			 if(animal.feedCount>0) {
	    				 animal.eat();
	    				 System.out.println("맛있다");
	    				 System.out.println(animal.name+"의 체력 : "+animal.life);
	    				 System.out.println(animal.name+"의 먹이개수 : "+animal.feedCount);
	    				 break;
	    			 }
	    			 System.out.println(animal.feed+" 먹이가 부족해요 \n퀴즈를 풀어서 먹이를 획득하세요");
	    			 break;
	    			 
	    		 case 2 : //잠자기 (3초동안)
	    			 System.out.print(animal.name+"이(가) 자는중");
	    			 for (int i = 0; i < 3; i++) {
						try {Thread.sleep(3000);} catch(InterruptedException e){;}
						System.out.println(".");
					}
	    			animal.sleep();
	    			System.out.println();
	    			break;
	    			
	    		 case 3: //산책하기
	    			 if(animal.life>1) {	//생명이 있을때 가능
	    				 Quiz quiz = animal.walk(qzAr);		//객체명. 필드명(메소드나 변수)
	    				 if(quiz.jackpot) {
	 						System.out.println(quiz.jackpot);//boolean jackpot은 true상태여야함. 이미 잭팟문제니까. 
	    					 System.out.println("잭팟 문제입니다! 맞추면 먹이 10개!");
	    				 }
	    				 System.out.println(quiz.quistion);
	    				 if(quiz.ansewer.equals(sc.next())) {
	    					 System.out.println("정답!");
	    					 animal.feedCount+=quiz.feedCount;
	    					 System.out.println(animal.feed+" "+quiz.feedCount+"개 획득!");
	    					 System.out.println(animal.feed+"개수 : "+animal.feedCount+"개");
	    					 break;
	    				 }
	    				 System.out.println("오답ㅠ");
	    				 animal.life--;
	    				 if(animal.life==0) {
	    					 System.out.print(animal.name+"이(가) 자는중");
	    	    			 for (int i = 0; i < 3; i++) {
	    						try {Thread.sleep(3000);} catch(InterruptedException e){;}
	    						System.out.println(".");
	    					}
	    	    			animal.sleep();
	    	    			System.out.println();		//위의 sleep복사, break는 따로 해주지않음
	    				 }
	    				 break;
	    			 }
	    			 System.out.println("체력이 부족해요ㅠㅠ 잠을 자고 오세요!");
	    		 case 4: //내정보
	    			 System.out.println("이름 : "+animal.name);
	    			 System.out.println("나이 : "+animal.age);
	    			 System.out.println("먹이 : "+animal.feed);
	    			 System.out.println("먹이 개수 : "+animal.feedCount);
	    			 System.out.println("체력 : "+animal.life);
	    		default:
	    			System.out.println("다시 입력해주세요");
	    			 break;
	    		 }
	    	 }
	     }
	}

}
