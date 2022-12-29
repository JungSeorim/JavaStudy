package arrayListTask;

import java.util.ArrayList;


public class DateApp {	
	//고객들의 정보를 담을 DB
	public ArrayList<Love> data = new ArrayList<>();		//객체타입을 제네릭으로 담기
	
	//이상형 추가
	public void wantType(Love love) {		//Love타입의 이름과 나이를 매개변수로 받기
		//DB에 담기
		data.add(love);		//넣을곳이 ArrayList타입이므로 ArrayList의 add메소드를 활용해 
									//입력받은 love를 저장해준다
	}
	
	//사용자가 입력한 나이인 이상형 목록 조회
	public ArrayList<Love> checkList(int wantAge) {
		ArrayList<Love> selceted = new ArrayList<Love>();
		Love love = null;		//저장하여 반환할 조회된 이상형
		for (int i = 0; i < data.size(); i++) {
			if(love.getAge()==wantAge) {
				selceted.add(love);
			}
		}
		return selceted;
	}
	
	//이상형의 나이수정
	public void modifyAge(Love love) {			//이미 수정할 나이를 받았다
		//(이상형의 번호를 추가) 
		//입력받은 이상형의
		//이상형 번호로 조회하여 수정
			Love temp = null;
			
			for (int i = 0; i < data.size(); i++) {
				//나이를 불러와서 일치하는 값 확인
				if(love.getLoveNum() == temp.getLoveNum()) {
				//바꿔준다 set
					
				}
			}
			
		//이상형의 나이순으로 정렬하기
		
		
	}
	
	
	
}
