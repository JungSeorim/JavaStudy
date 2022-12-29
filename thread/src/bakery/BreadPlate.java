package bakery;

public class BreadPlate {

   public static BreadPlate breadPlate;
   
   public int breadCount;		//현재 빵
   public int eatCount;			//먹은 빵
   
// 싱글톤 패턴
// 객체는 무조건 한 개만 만들고 돌려 쓴다. 
   //생성자를 호출하여 new연산자를 쓸 수 없어야한므로
   //private으로 선언하고 
   private BreadPlate() {;}
   
   //생성자를 호출하는 다른 방법인 getInstance() 메소드를 선언해준다
   public static BreadPlate getInstance() {
      if(breadPlate == null) {
         breadPlate = new BreadPlate();
      }
      return breadPlate;
   }
   
//   빵만들기
//   만든 빵이 9개가 넘어가면, 쓰레드를 멈춰준다.
   public synchronized void makeBread() {		//자원이 공유되어 명령어를 적용시킬 스레드가
      if(breadCount > 9) {									//어떤 스레드인지 알 수 없으므로 동기화 해야한다
         System.out.println("빵이 가득 찼습니다.");
         try {wait();} catch (InterruptedException e) {BreadMaker.check = true;}
      }else {
         breadCount++;
         System.out.println("빵을 1개 만들었습니다. 현재 빵 개수 : " + breadCount + "개");
      }
   }
   
//   빵먹기
//   만든 빵이 0개면 못먹고, 먹은 빵이 20개면 못먹는다.
//   만약 빵을 먹게 되면, 멈춰있던 쓰레드를 깨워준다.
   public synchronized void eatBread() {
      if(eatCount == 20) {
         System.out.println("빵이 다 떨어졌습니다!");
         
      }else if(breadCount < 1) {		//빵을 0 개 먹었는데 먹을수 있는 빵의 개수도 0개면 안되니까 else if
         System.out.println("🍩🍩🍩🍕빵을 만들고 있어요~!🍕🍔🍔🍔");
         
      }else {
         eatCount++;
         breadCount--;
         System.out.println("빵을 1개 먹었습니다. 현재 빵 개수 : " + breadCount + "개");
         notify();		//빵을 중간에 먹을 수도 있기 때문에 breadCount가 <= 9일때도 깨워줄수 있어야한다
         					//그래서 makeBread의 wait()을 notify()로 깨워준다.
         					//얘가 wait()를 깨우는지 어떻게 알지요? = 공유객체를 통해 안다
      }
   }
}