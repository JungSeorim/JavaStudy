package bank;

public class ShinhanBank extends Bank{
   @Override
   public void deposit(int money) {
      money *= 0.5;
      super.deposit(money);
   }
}