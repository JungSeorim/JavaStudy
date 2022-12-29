package markerInterfaceTest;

public class Lab{
	
	//근데 이 인터페이스가 동물->동물이름->식성분류를 구분해주는 마크인터페이스가 되기도 한다.
	public void checkKinds(Animal []animal) {
		//외부에서 Animal타입의 배열을 전달받고
		//instanceOf를 사용하여 종을 검사한다.
		for (int i = 0; i < animal.length; i++) {
			if(animal[i] instanceof HerbivoreMarker) {		//인터페이스는 하나의 타입
				System.out.println("초식동물입니다."); 
			}else if(animal[i] instanceof CarnivoreMarker) {
				System.out.println("육식동물입니다.");
			}else {
				System.out.println("잡식동물입니다.");
			}
		}
		
	}
	
	//외부에서 모든 동물을 받아와서 
	//초식동물인지 육식동물인지 잡식동물인지 구분하는 메소드
	//초식동물 : Herbivore 					marker interface
	//육식동물 : Carnivore
	
	public static void main(String[] args) {
		Lab lab = new Lab();
		Animal[]animal= {
				new Cow(),
				new Bear(),
				new Tiger(),
				new Dog()
		};
		lab.checkKinds(animal);
	}
}
