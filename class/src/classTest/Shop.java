package classTest;

import java.util.Scanner;

//true false의 주체가 뭔지 잘 봐야함

class SuperCar{
	//브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	String password;
	
	//초기값false가 꺼진상태인것으로.
	boolean check;	//두 메소드에서 사용하는 전역변수  //boolean의 자동 초기값 = false
	
	//기본생성자 (초기화) (원하는 비밀번호가 없는 경우 기본 비밀번호)
	SuperCar(){
		password = "0000";
	}
	
	//매개변수 생성자 (원하는 비밀번호가 있으면 여기에)
	public SuperCar(String brand, String color, int price, String password) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.password = password;
	}
	
	//매개변수 생성자 (시동키기 위해 비번치는 매개변수생성자)
	//오버로딩
	public SuperCar(String password) {
		this.password = password;
	}

	
	//시동키기
	 boolean engineStart(){	//시동 키려고 하는데
		 //!(false)는 true이므로 if문 안에 있는 문장을 실행한다.
		if(!check) {					//!check=true, check=false임.
				check = true;		//check = true로 정의.
				return true;			//engineStart = true, 성공!
			}
		return false;				//engineStart = false, 실패!
	}
	 
	 


	//시동끄기
	boolean engineStop() {	//시동을 꺼줄건데
		if(check) {						//시동 켜졌니(false)?				check = 값		
			check = false;			//응 켜졌어
			return true;		 		//시동끄기 성공
		}
		return false;				//시동이 켜졌다면 시동이 켜져있다고 알려줄게(powerOff를 못했다 = false)
	}

	

	
//심화
//시동을 켜기 위해서는 비밀번호 4자리를 입력해야한다.
//입력한 비밀번호가 3회 연속 실패하면 "경찰출동"메세지를 출력한다.
	boolean checkPassword(String userPassword) {
		//일치하면 true
		return password.equals(userPassword);
	}

}




public class Shop {
	public static void main(String[] args) {
		
	//객체 생성
	SuperCar ferrari = new SuperCar();
	
	//변수 선언
	int choice = 0, count=0;
	String msg = "1.시동키기\n2.시동끄기", loginMsg = "비밀번호 입력 : ", pw = null;
	
	//Flag : 
	//켜져있는 상태에서 누군가 끄면
	boolean stoppedEngine=false;	//켜져있다
	//시동이 켜진 후 시동을 끄기에 성공하면 true
	
	//시동키기 or 끄기 입력받기
	Scanner sc = new Scanner(System.in);
	
	do {
		System.out.println(msg);
		choice = sc.nextInt();
		
		switch(choice){
		
		//시동키기
	case 1:	
			if(!ferrari.check) {		//true로 바꿈 = "powerOn메소드가 true상태여야 실행할수있는 환경"라면 실행★★★★★★
				System.out.println(loginMsg);
				System.out.println(!ferrari.check);	//true
			pw = sc.next();
				if(ferrari.checkPassword(pw)) {	
						ferrari.engineStart();
						count=0;								//시동이 켜지면 초기화해야함(누적x)
						System.out.println("시동 켜짐");					
				}else {
					count++;
					System.out.println("오류 횟수 "+count+"회");
					if(count==3) {
						System.out.println("경찰 출동");
					}
				}
				break;	 //즉시탈출 아래로 더이상 내려가지 않음
			}
			System.out.println("이미 시동이 켜져있습니다.");
			break;

		//시동끄기
		case 2:	
			//시동끄기를 시도한 결과를 stoppedEngine Flag에 담아준다.
			//==가 아닌 이유 : engineStop이 먼저 담긴후 stoppedEngine에 담김
			if(stoppedEngine = ferrari.engineStop()) {		//ferrari.engineStop값은 true 이므로 stoppedEngine=true
				System.out.println("시동 꺼짐"+ferrari.check);
				break;
			}
				System.out.println("이미 시동이 꺼져있습니다."+ferrari.check);	//stop이 안되는 환경 = 현재 꺼져있는 상태
				break;
		}
		}while(!stoppedEngine && count !=3);	// stoppedEngine(null)이 false여야하며, 비밀번호가 연속 3회 틀리지않아야 while문 실행
	}            //시동끄기에 성공했을때=stoppedEngine는 true = while문 탈출
				//시동이 안꺼지고 3번 틀려서 "켜져있는" 상태는 while문이 계속 돈다
}