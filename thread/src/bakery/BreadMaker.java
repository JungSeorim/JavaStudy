package bakery;

public class BreadMaker implements Runnable{
   
   public static boolean check;
   
   @Override
   public void run() {
//      빵을 20개 만든다.
      int i = 0;
      for (i = 0; i < 20; i++) {
         BreadPlate.getInstance().makeBread();
         if(check) {break;}									//wait일 때도 탈출, 
         try {Thread.sleep(300);} 		//빵 만드는 속도 조절
         catch (InterruptedException e) {break;}	//sleep일 때도 탈출
      }
      if(i != 20) {
         System.out.println("안녕히 가세요");
         return;	//재료소진이 안뜨게 하기위해
      }
      System.out.println("재료 소진");
   }
}