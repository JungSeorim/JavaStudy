package casting;

//부모
class Car{
	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
}

class SuperCar extends Car{
	@Override
	void engineStart() {
		super.engineStart();
		System.out.println("음성으로 시동 킴");
	}	
	
	void openRoof() {
		System.out.println("지붕 열기");
	}
}

public class CastingTest {
	public static void main(String[] args) {
		
		//up casting
		//자식은 (짤려서) 부모한테 들어갈 수 있음
//		Car noOptionFerrari = new SuperCar();	
											//SuperCar타입의 값을
		//Car 타입의 값으로 바꿔주는것은
																						//업캐스팅이다.
		
		
		

		//숨겨진 부분
//		noOptionFerrari.engineStart(); //upcasting했더라도 자식에서 재정의한 값

		//오류
//		noOptionFerrari.engineStart(); 
		
		//오류
//		SuperCar brokenFerrari = new Car();	
		//부모는 자식에 들어갈 수 없다
		//부모타입은 자식타입이 아니므로 (즉 타입이 달라서)

		//오류
//		SuperCar brokenFerrari = (SuperCar)new Car();	
		//부모타입은 자식타입으로 다운캐스팅이 아닌 오류
		//새로운 Car타입 값

		//down casting (다시 채워짐)
//		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		
		
		
		
		
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
////      matiz instanceof Car : true
//      System.out.println(matiz instanceof Car);
////      matiz instanceof SuperCar : false
//      System.out.println(matiz instanceof SuperCar);
////      ferrari instanceof Car : true
//      System.out.println(ferrari instanceof Car);
////      ferrari instanceof SuperCar : true
//      System.out.println(ferrari instanceof SuperCar);
////      noOptionFerrari instanceof Car : true
//      System.out.println(noOptionFerrari instanceof Car);
////      noOptionFerrari instanceof SuperCar : true
//      System.out.println(noOptionFerrari instanceof SuperCar);
////      fullOptionFerrari instanceof Car : true
//      System.out.println(fullOptionFerrari instanceof Car);
////      fullOptionFerrari instanceof SuperCar : true
//      System.out.println(fullOptionFerrari instanceof SuperCar);

	}
}
