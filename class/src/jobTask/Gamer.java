package jobTask;

import java.util.Random;

//프로게이머
public class Gamer {
	String name;
	int income=0;	
	int winRating;
	
	//처음 시작인지 아닌지 확인 flag
	boolean check = false;
	
	boolean win = false;
	int winCount = 0;
	int looseCount = 0;

	
	Random r = new Random();

	//기본생성자
	public Gamer() {}
	
	//매개변수 생성자
	public Gamer(String name, int income, int winRating, boolean check,boolean win, int winCount, int looseCount, Random r) {
		super();
		this.name = name;
		this.income = income;
		this.winRating = winRating;
		this.check = check;
		this.win = win;
		this.winCount = winCount;
		this.looseCount = looseCount;
		this.r = r;
	}

	
	
	//대회출전하시겠습니까? 승리, 패배
	int winGame() {
		
		int[]percent = new int[10];
		
		//초기 승률 설정
		if(!check) {
			check=true;
			this.winRating=30;							//30퍼센트로 이길확률
			for (int i = 0; i < winRating/10; i++) {
				percent[i]=1;
				if(percent[r.nextInt(percent.length)]==1) {
					win=true;
					winCount++;	
					income+=150000;
				}else {
					win=false;
					looseCount++;
					income-=50000;
				}
			}
			return income;
		}else if(check){
			for (int i = 0; i < winRating/10; i++) {
				percent[i]=1;
				if(percent[r.nextInt(percent.length)]==1) {
					win=true;
					winCount++;	
					income+=150000;
				}else {
					win=false;
					looseCount++;
					income-=50000;
				}
			}
		}
		return income;
		
	}



	//장비를 구매하시겠습니까?
	int changeDevice(int upGrade) {
		winRating += upGrade;
		return winRating;
	}
	
}