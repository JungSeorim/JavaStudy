package bakery;

public class ThreadTest implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("실행중");
			if(Thread.interrupted()) {		//interrupted()가 true가 됐다면
//				Thread.interrupted();		//두번쓰면 메소드 두번이라서 쓰면X
				break;
			}
		}
	}
}
