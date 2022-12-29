package threadTest;

public class Thread1 extends Thread{

	public String data;

	public Thread1() {}
	
	public Thread1(String data) {
		super();
		this.data = data;
	}

	//run에 스케줄링(운영체제에 알려주는 역할) 해줌(sleep)
	//sleep 쓸 때 try catch문 써줌
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {Thread.sleep(1000);}
			catch(InterruptedException e){
			}
		}
	}
}
