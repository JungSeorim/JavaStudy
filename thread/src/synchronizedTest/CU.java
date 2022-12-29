package synchronizedTest;

public class CU {

	public static void main(String[] args) {
		//ATM은 자원
		ATM atm = new ATM();

		//자원의 공유
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
	}

}
