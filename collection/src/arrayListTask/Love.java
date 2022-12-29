package arrayListTask;

public class Love {
	//이름, 나이
	//private
	//기본생성자
	//toString()
	
	private String name;
	private int age;
	private int loveNum;
	
	public Love() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getLoveNum() {
		return loveNum;
	}

	public void setLoveNum(int loveNum) {
		this.loveNum = loveNum;
	}

	public String toString() {
		return loveNum+", "+name+", "+age;
	}
	
	
}
