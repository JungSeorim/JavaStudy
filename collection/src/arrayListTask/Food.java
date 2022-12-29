package arrayListTask;

public class Food{
	//이름, 가격, 종류(한식, 중식, 일식, 양식)
	//private
	//기본생성자
	//toString
	
	private String name;
	private double price;
	private String kind;
	
	public Food(){;}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public double setPrice(double price) {
		return this.price = price;
	}

	
	public String toString() {
		return name+", "+price+", "+kind;
	}
	
}
