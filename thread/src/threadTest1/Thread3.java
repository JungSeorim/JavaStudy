package threadTest1;

public class Thread3 implements Runnable{
	
	public String sound;
	
	public Thread3() {;}
	
	public Thread3(String sound) {
		this.sound = sound;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			//스레드의 이름을 동물울음으로
            System.out.println(Thread.currentThread().getName());
            try { Thread.sleep(1000);} catch (Exception e) {}
         }			
		}
		
}
