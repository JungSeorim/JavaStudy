package bank;

public class Bank {
	//3개의 은행, 100명의 고객(을 받을수있도록 100개를 만들어둠)
   public static Bank[][] arrBank = new Bank[3][100];
  
   // 계좌가 개설된 은행만 : 은행 3개
   public static int[] arCount = new int[3];
   
   //private는 다른 클래스(특정은행)에서 접근불가함
   private String name;
   private String account;
   private String phoneNumber;
   private String password;
   private int money;	//잔고
   
   //기본생성자
   public Bank() {;}

   //매개변수 생성자
   public Bank(String name, String account, String phoneNumber, String password, int money) {
      this.name = name;
      this.account = account;
      this.phoneNumber = phoneNumber;
      this.password = password;
      this.money = money;
   }

   //getter setter
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAccount() {
      return account;
   }
   public void setAccount(String account) {
      this.account = account;
   }
   public String getPhoneNumber() {
      return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public int getMoney() {
      return money;
   }
   public void setMoney(int money) {
      this.money = money;
   }
   
   //중복검사와 로그인은 data가 없을 때에도 가능해야한다
   //계좌번호가 없을 때 (객체가 없을 때)도 있을때도 활용해야 하기 때문에 
   //static을 활용하여 메소드를 만든다
   
   
//   계좌번호 중복검사
   public static Bank checkAccount(String account) {	
	   // 계좌번호받아서 중복검사 한뒤 , 다시Bank타입의 값을 return
      /* 계좌번호를 받는다는 것은 이미 번호가 존재한다는 뜻?
	   -->계좌번호가 생성전후 모두  checkAccount메소드를 통해 확인해야하므로 
	  */
	  // 계좌번호가 없는 경우인 객체생성전을 대비해 static을 사용한다.
	   
	   Bank bank = null;		// Bank타입 객체 생성(Bank타입이기 때문에 주소값이 들어가므로 null, ""은 반복임)
	   									//bank를 생성해준 이유는: 나중에 이 메소드를 또 쓸때 누적시키지 않으려고.
      for (int i = 0; i < arrBank.length; i++) {		//배열을 반복하여 확인
         int j = 0;		// 다시 사용해주려고
         for (j = 0; j < arCount[i]; j++) {				// ?? 
        	//만약 arrBank의[은행사]행 [회원명]열의 값이 입력한 account와 같다면
            if(arrBank[i][j].account.equals(account)) {
               bank = arrBank[i][j];		// 그 값을 Bank타입 객체에 담는다 
               break;
            }
         }
         if(j != arCount[i]) {break;}		// ?? arCount값이 j가 아닌경우 반복문을 멈춤
      }
      return bank;
   }
   
   
//   핸드폰 번호 검사
   public static Bank checkPhoneNumber(String phoneNumber) {
	   //폰번호를 받아서 중복검사를 한 뒤 Bank타입 객체 return
      Bank bank = null;
      for (int i = 0; i < arrBank.length; i++) {
         int j = 0;
         for (j = 0; j < arCount[i]; j++) {
            if(arrBank[i][j].phoneNumber.equals(phoneNumber)) {
            	//해당 값의 폰번호가 입력한 폰번호와 일치한다면
               bank = arrBank[i][j];	//그 값은 Bank타입 객체이다.
               break;
            }
         }
         if(j != arCount[i]) {break;}		//만일 j가 arCount값이 아니라면 반복종료
      }
      return bank;
   }
   
   
//   로그인
   //계좌번호와 비번을 입력하여 로그인 할건데,
   //모든 객체가 공유하는 로그인정보(블록체인, 겹치면 안되는것)이므로 static
   public static Bank login(String account, String password) {
	// 입력받은 계좌번호가 저장된 계좌번호와 중복되는게 있는지 묻는 checkAccount메소드
	 //그래야 로그인을 하니까
	   
      Bank bank = checkAccount(account);
      if(bank != null) {			//만일 Bank타입 bank가 비어있지 않다면 (입력해둔 값이 있다면)
         if(bank.password.equals(password)) {		//저장비번과 입력비번이 일치하는지까지 비교하고
            return bank;		//로그인회원 전체정보를 리턴한다(전체정보가 무엇인가?)
         }
      }
      return null;			//그렇지 않다면 Bank값을 다시 비워라.
   }
   
   
   
//   입금
   public void deposit(int money) {
      this.money += money;
   }
//   출금
   public void withdraw(int money) {
      this.money -= money;
   }
//   잔액조회
   public int showBalance() {
      return money;
   }
   
}











