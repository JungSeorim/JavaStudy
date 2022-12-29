package lamdaTask;

//함수형 인터페이스, 단 하나의 추상메소드만 선언 가능.
@FunctionalInterface
public interface Calc {
	//두정수를 입력받은 후 더하거나 빼서 리턴한다
	public int calc(int num1, int num2);
}
