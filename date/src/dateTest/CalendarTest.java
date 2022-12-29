package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd aaa hh:mm:dd");
//		Calendar today = Calendar.getInstance();
//		System.out.println(today);
//		
//		//Object타입에서 Date타입으로 변경 .getTime()
//		System.out.println(simpleDateFormat.format(today.getTime()));
		
		Calendar date = Calendar.getInstance();
//		date.set(2000, 11, 04);		//month도 0부터 시작하기 때문에 11을 전달해야 12월 출력
//		date.set(Calendar.YEAR, 2000);		//하나만 바꾸고싶은 경우
//		System.out.println(simpleDateFormat.format(date.getTime()));		//set한 날짜 시간값
		System.out.println(date.get(Calendar.YEAR));	//가져오기
		System.out.println(date.get(Calendar.MONTH)+1);	//가져올때는 필드값 밖에서 +1
		
	}

}
