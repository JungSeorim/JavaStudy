package interfaceTest;

public interface Pet {
	//어차피 interface는 상수밖에 못쓰니까 생략되어 오류없음
	final static int eyes = 2;
	int nose = 1;
	
	public abstract void bang();
	public void giveYourHand();
	public void bite();
	public void sitDown();
	public void waitNow();
	public void getNose();
}
