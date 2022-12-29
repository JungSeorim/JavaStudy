package synchronizedTest;

public class ATM implements Runnable{
				//ATM전체가 자원이다
	public int money;
	
	public ATM() {
		this(10000);
	}
	
	public ATM(int money) {
		super();
		this.money = money;
	}

	//자원
	public synchronized void withdraw(int money) {
//		synchronized (this) {	//동기화할 자원의 객체를 this에 넣어주기	//내가 나에게 걸기때문에 this
			this.money -= money;
		System.out.println(Thread.currentThread().getName()+"가"+money+"원 출금");
		System.out.println("현재 잔액 : "+this.money+"원");
	}
	
	//run에서 Thread 클래스 사용
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdraw(1000);
			try {
				Thread.sleep(1000);	//1초
			} catch (Exception e) {}
		}
	}
	
}
