package inheritanceTest;

class Car{
	//브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	
	//기본생성자
	public Car() {}
	
	//매개변수 생성자, 초기화 생성자
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	//열쇠로 시동킴
	void engineOn() {
		System.out.println("열쇠로 시동킴");
	}
	
	//열쇠로 시동끔
	void engineOff() {
		System.out.println("열쇠로 시동끔");
	}
}

class SuperCar extends Car{
	//모드
	String mode;
	
	//기본생성자
	//자식 기본생성자는 부모의 기본생성자를 호출한다.
	//부모에 기본 생성자가 없으면 자식의 기본 생성자는 오류가 발생한다.
	public SuperCar() {}
	
	//초기화생성자
	public SuperCar(String brand, String color, int price, String mode) {
		//부모의 생성자중 3개의 값을 전달받는 생성자 호출
		super(brand, color, price);		//super를 직접 써줘야하는 경우
		this.mode=mode;
	}
	
	
	//음성으로 시동킴
	@Override
	void engineOn() {
//		super.engineOn(); 		//super.메소드() : 열쇠로도 시동킬 수 있게된다
		System.out.println("음성으로 시동킴");
	}
	//음성으로 시동끔
	@Override
	void engineOff() {
		System.out.println("음성으로 시동끔");
//		super.engineOff(); 		//이 자체는 메소드(값X)이기 때문에 순서 바뀌어도 상관없음
	}
	
	//지붕열기
	void openRoof() {
		System.out.println("지붕열기");
	}	
	//지붕닫기
	void closeRoof() {
		System.out.println("지붕닫기");
	}
}

public class InheritanceTask {

	public static void main(String[] args) {
		SuperCar myCar= new SuperCar();
		myCar.engineOn();
		myCar.engineOff();
		myCar.openRoof();
		myCar.closeRoof();
		
	}
}
