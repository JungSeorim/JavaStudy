package arrayListTask;

import java.util.ArrayList;

public class Market {
	//과일들을 저장할 DB선언
	public static ArrayList<Fruit> data= new ArrayList<>();	//사용은 메소드 안에서

	//과일 추가 (ArrayList 메소드 활용x, 과일을 추가하는 메소드, 메소드로 만들 줄 알아야한다)
	public void addFruit(Fruit fruit) {		//매개변수는 한번에 받아와야 한다(dbms활용을 위해)
		data.add(fruit);		//ArrayList에 넣는법
	}
	
	//과일 삭제
	//과일의 이름을 외부에서 받아온다.
	//DB에서 과일의 이름을 검색한다.
	//과일의 이름이 검색되면 해당 객체를 저장한다.
	//저장한 객체를 DB에서 삭제한다.
	public void removeFruit(String name) {		//fruit는 저장된 fruit
		Fruit fruit = null;
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getName().equals(name)) {
				data.remove(fruit);
			}
		}
	}	
	
	
	//과일 가격이 평균가격보다 낮은지 검사
	//평균가격
	public static double getAverage() {
		int total = 0;
		double average =0;
		
		//총합
		for (int i = 0; i < data.size(); i++) {
			total+=data.get(i).getPrice();
		}
		//평균
		average = total/data.size();
		return average;
	}
	
	//낮은지 검사
	public boolean checkLower(Fruit fruit) {
		return fruit.getPrice() < getAverage();
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		Market mk = new Market();
		
		fruit.setName("사과");
		fruit.setPrice(3000);
		mk.addFruit(fruit);
		
		
	}
	
}
