package dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date =  new Date();
		Date time = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 mm월 dd일 HH시 mm분 ss초");
		
//		date.setYear(100);		//Deprecated, 1900에 더하는 숫자 ()
//		date.setMonth(11);
		
//		System.out.println(date);
		System.out.println(simpleDateFormat.format(date));
		
		//parse
		try {
			time = simpleDateFormat.parse("2022년 12월 04일 09시 00분 00초");
			System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}		//parse Exception이 발생하여 빨간줄, try catch 로 해야함

		
	}
}
