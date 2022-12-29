package objectTest;

import java.util.Random;

class Employee{
   int number;
   String name;
   
   public Employee() {;}

   public Employee(int number, String name) {
      super();
      this.number = number;
      this.name = name;
   }
   
   //주소값이 일치 하지 않아서.
//	주소비교, 타입비교, 다운캐스팅 값비교
   public boolean equals(Object obj) {
	if(obj == this) {
		return true;
		}
	if(obj instanceof Employee) {
		Employee secondEmployee = (Employee)obj;
		if(this.number == secondEmployee.number) {
			return true;
		}
	}
	return false;
   }
}


public class EqualsTest {
   public static void main(String[] args) {
      
	   //true나오도록
      Employee han = new Employee(1, "한동석");
      System.out.println(han.equals(new Employee(1, "한동석")));
      
//      String data1 = "ABC";
//      String data2 = "ABC";
//      String data3 = new String("ABC");
//      String data4 = new String("ABC");
//      
//      System.out.println(data1 == data2);
//      System.out.println(data1.equals(data2));
//      
//      System.out.println(data3 == data4);
//      System.out.println(data3.equals(data4));
      
//      Random r1 = new Random();
//      Random r2 = new Random();
//      
//      System.out.println(r1 == r2);
//      System.out.println(r1.equals(r2));
//      
//      r1 = r2;
//      System.out.println(r1 == r2);
//      System.out.println(r1.equals(r2));
      
   }
}