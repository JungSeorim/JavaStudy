package AmbiguityTest;

public interface InterA {
	default void printData() {	//abstract를 없애주기 위해 default 를 앞에 붙여준다
		System.out.println("InterA");
	}
}
