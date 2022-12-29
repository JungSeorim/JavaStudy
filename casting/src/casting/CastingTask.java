package casting;

//부모클래스
class Netflix{
	
	void function() {}
	
}

//자식클래스
class Animation extends Netflix{
	@Override
	void function() {
		System.out.println("자막지원");
	}
}

//자식클래스
class Movie extends Netflix{
	@Override
	void function() {
		System.out.println("4D");
	}
}

//자식클래스
class Drama extends Netflix{
	@Override
	void function() {
		System.out.println("굿즈판매");
	}
}



public class CastingTask {
	//넷플릭스
	//애니메이션, 영화, 드라마 클래스 선언
	//사용자가 선택한 영상이 
	//애니메이션이라면 "자막지원"기능 사용 ; 출력기능
	//영화라면 "4D"기능 사용
	//드라마라면 "굿즈"기능 사용
	
	//공통타입선언 (부모클래스)
	//업캐스팅 (세가지 기능이 짤림)
	//타입비교 후 (instanceof)
	//true뜨면 그 타입으로 down casting

		//자식클래스 객체
//		Animation spongeBob = new Animation();
//		Movie spiderMan = new Movie();
//		Drama wooYoungWoo = new Drama();		
		
	static void check(Netflix name) {						//Netflix타입의 변수를 받겠다
		if(name instanceof Animation) {
			Animation spongeBob = (Animation)name;
			spongeBob.function();
		}else if(name instanceof Movie) {
			Movie spiderMan = (Movie)name;
			spiderMan.function();
		}else if(name instanceof Netflix) {
			Netflix wooYoungWoo = (Netflix)name;
			wooYoungWoo.function();
		}
	
	} 
	public static void main(String[] args) {
		Netflix a = new Animation();
		check(a);
	}
	
	//풀이
//	 public static void main(String[] args) {
//	      CastingTask ct = new CastingTask();
//	      ct.check(new Animation());
//	      ct.check(new Film());
//	      ct.check(new Drama());
//	   }

}
	
