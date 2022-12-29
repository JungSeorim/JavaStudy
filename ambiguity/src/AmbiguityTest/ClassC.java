package AmbiguityTest;

public class ClassC implements InterA, InterB{
	//pirntData 메소드명이 겹칠때
	//둘중에 하나는 재정의 해서 쓰면된다
	@Override
	public void printData() {
		InterA.super.printData();	//여기에 어떤 인터페이스인지 나와있다
	}
		
}
