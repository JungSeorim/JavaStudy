package dateTest;

import java.util.Calendar;
import java.util.Date;

public class CalendarTask {
	public static void main(String[] args) {
//		본인의 생년월일 출력
		Calendar birthday = Calendar.getInstance();
		birthday.set(1997, 05, 15);
		System.out.println(birthday.getTime());
		
	}
}
