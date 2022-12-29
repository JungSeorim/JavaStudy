package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
//		
//		//멀티스레드
//		t1.start();
//		t2.start();
//		
//		//단일스레드
//		t1.run();
//		t2.run();

		Runnable runner = () -> {
			for (int i = 0; i < 5; i++) {
	            System.out.println(Thread.currentThread().getName());
	            try { Thread.sleep(300);} catch (Exception e) {}
	         }
		};
		
		Thread2 t3 = new Thread2();
		Thread2 t4 = new Thread2();

		//t3.start(); 불가능
		
		Thread thread1 = new Thread(t3,"!");	//업캐스팅 Runnable t3 = new Thread2();도 가능
		Thread thread2 = new Thread(t4,"?");
		
		thread1.start();
		thread2.start();
		
		//우선순위를 줘도 섞이는 경우가 다반사
		
		//join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
		//				이미 start된 스레드는 영향을 받지 않는다.
		// 				만약 나중에 실행하고자 하는 스레드가 있다면, join()다음에 start()를 실행해야한다
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("main 쓰레드 종료");
	}
}
