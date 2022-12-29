package classTest;

class Car{
	String brand;
	String color;
	int price;
	//전역변수들은 자동초기화
	
	//매개변수 생성자
	//Alt + Shift + S + O : Constructor
	public Car(String brand, String color, int price) {	//public은 나중에
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//오버로딩, 다형성
	public Car(String color) {
		brand = "자동차";		//this생략가능
		this.color = color;
	}

	void engineStart() {
		System.out.println(this.brand +"시동 켜기");		//this생략가능
	}
	
	void engineStop() {
		System.out.println(brand + "시동 끄기");
	}
}

public class Road {
//실행프로그램을 만들어주는 메소드
	public static void main(String[] args) {
		Car momCar = new Car("Benz","Black",10_000);
		Car dadyCar = new Car("BMW","Blue",8_000);
		Car myCar = new Car("Red");
		
		
		//이걸 안하려고 "초기화" 해주는것
//		momCar.brand = "Benz";
//		momCar.color = "Black";
//		momCar.price = 10_000;			//10,000을 표현
//		
//		dadyCar.brand = "BMW";
//		dadyCar.color = "Blue";
//		dadyCar.price = 8_000; 
		
		
	}

}
