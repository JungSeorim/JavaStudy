package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
   public static void main(String[] args) {
      BreadMaker breadMaker = new BreadMaker();
      Thread maker = new Thread(breadMaker);
      BreadPlate breadPlate = BreadPlate.getInstance();		//같은 주소를 불러옴(같은 빵집)
      String[] btns = {"빵 먹기", "나가기"};		// 0 : 빵먹기 1 : 나가기 -1 : exit
      int choice = 0;
      
      ImageIcon icon = new ImageIcon("src/img/bread2.gif");
      
      //화면 하나 : 빵 만들기
      maker.start();
      
      //화면이 두 개 : 빵먹는 것은 대화상자에서
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION,
               JOptionPane.PLAIN_MESSAGE, icon, btns, null);
         
         //0버튼 = 빵먹기
         if(choice == 0) {
            breadPlate.eatBread();
         }else {
            System.exit(0);	
//            maker.interrupt();					//실행되고 있는 스레드의 exception을 발생시켜주는 interrupt
//            break;
         }
      }
   }
}
