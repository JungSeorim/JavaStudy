package jobTask;

import java.util.Scanner;

//대회
public class Game {
	
	public static void main(String[] args) {
		Gamer player = new Gamer();
		Scanner sc = new Scanner(System.in);
		
		//이길확률
		
		
		String title ="★★★★★★★★★★★★★★★★★";
		String NameMsg = "프로게이머의 이름을 입력하세요 : ";
		String menu = "1. 대회출전(참가비 50000원)\n2. 장비 업그레이드\n3. 내 정보\n4. 나가기";
		int menuNum=0;
		
		//게임시작
		while(true) {
			System.out.println(title);
			System.out.print(NameMsg);
			String gamerName = sc.next();
			System.out.println("프로게이머 "+gamerName+"님 환영합니다!");
			
			
			while(true) {
				System.out.println();
				System.out.println(menu);
				menuNum = sc.nextInt();

				if(menuNum==4) {	break;	}
				
				switch(menuNum) {
				case 1 : //대회출전
					System.out.println("⚔⚔ 대회출전 ⚔⚔");
					player.winGame();
					
					//이겼는지 졌는지 확인?
					if(player.win) {	
						//승리
						System.out.println("wow! 대회에서 승리하였습니다!");
						System.out.println("상금 150,000원 상금획득! (참가비 면제)");
						}	//패배
					else {
						System.out.println("대회에서 패배하였습니다 ㅠㅠ");
						System.out.println("참가비용  50,000원을 잃었습니다");
					}
					System.out.println("잔고 : "+player.income+"원");		
					//if문에서 실행한 income값을 어떻게 저장하여 누적시키는가
					//=+가 아닌 +=로 해야한다... 왜?
					break;
				
				case 2: //장비구매
				if(player.income>2500) {
					System.out.println("어떤 장비를 업그레이드 하시겠습니까?");	
					System.out.println("1.마우스(2,500원)\n2.모니터(5,000원)\n3.본체(20,000원)");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1 :
						player.changeDevice(1);		// 승률 1%증가
						System.out.println("장비 업글은 필수지!");	
						player.income -=2500;
						System.out.println("승률 : "+player.winRating+"%로 증가!");
						System.out.println("잔고 : "+player.income+"원");
						break;
					
					case 2 : 
						player.changeDevice(3);		//승률 3%증가
						System.out.println("모니터는 좋은 걸 사야지!");	
						player.income -=5000;
						System.out.println("승률 : "+player.winRating+"%로 증가!");
						System.out.println("잔고 : "+player.income+"원");
						break;

					case 3 : 
						player.changeDevice(6);		//승률 6% 증가
						System.out.println("비싸긴 해도 미래를 위해 투자해야지!");
						player.income -=20000;
						System.out.println("승률 : "+player.winRating+"%로 증가!");
						System.out.println("잔고 : "+player.income+"원");
						break;		
				}
				}else {
					System.out.println("🙀잔고부족🙀\n돈 벌어오세요");
				}
				break;
				
				case 3 :	//내정보
					System.out.println("○○○○○내정보○○○○○");
					System.out.println("이름 : "+gamerName);
					System.out.printf("나의 전적 : %d승 %d패\n",player.winCount,player.looseCount);
					System.out.println("잔고 : "+player.income+"원");
					System.out.println("○○○○○○○○○○○○○○");
					break;
				
				default:
					System.out.println("다시 입력하세요");
					break;
		}
	}
	}
	}		
	
}
