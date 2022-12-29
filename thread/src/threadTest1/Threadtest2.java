package threadTest1;


public class Threadtest2 {

	public static void main(String[] args) {

		//Thread3은 runnable인터페이스 상속
		Thread3 cat  = new Thread3();	
		Thread3 dog = new Thread3();
		Thread3 tiger = new Thread3();
		
		//업캐스팅
		Thread t1 = new Thread(cat,"야옹");		// Thread(Runnable객체, "객체명")
		Thread t2 = new Thread(dog,"멍멍");
		Thread t3 = new Thread(tiger,"어흥");
		
		t1.start();
		t2.start();
		
		//join으로 우선순위
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		
		t3.start();
		
	}

}
