package threadTest;

//실무에서는 Thread보다 Runnable을 더 쓴다
public class Thread2 implements Runnable{
		public void run() {
			//run안에 접근한 것을 자원이라고 한다
			for (int i = 0; i < 10; i++) {
				//이 안에 접근한 쓰레드의 이름을 가져온다
				System.out.println(Thread.currentThread().getName());
				try{Thread.sleep(500);} catch(InterruptedException e) {;}
			}
	}
}
