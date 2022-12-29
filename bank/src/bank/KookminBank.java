package bank;

public class KookminBank extends Bank{
   @Override
   public void withdraw(int money) {
      money *= 1.5;		//출금할 돈에 50퍼 수수료를 받고			//두번의 자동형변환. (1:정수*실수 2 : 실수를 다시 정수에 넣음)
      super.withdraw(money);		//입금된 돈을 가져와야함
   }
}