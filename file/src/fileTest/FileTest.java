package fileTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException{	//예외 던지기
		//절대 경로 : 어디에서 작성해도 찾아갈 수 있는 경로 C:/a/b
		//상대 경로 : 현재 위치에 따라 변경되는 경로 ../a/b
		
		//출력은 writer
//		try {
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt",true));
////			bufferedWriter.write("정서림\n");	//경로가 없으나 출력이므로 만들어준다
//			bufferedWriter.write("정서림");
//			bufferedWriter.newLine();	// \n 또는 \r\n으로 split해야한다
//			bufferedWriter.close(); 		//close해주지 않으면 buffer로만 남아있다
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		File file = new File("test.txt");		//경로를 전달
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;
			 while((line = bufferedReader.readLine()) != null) {
		            System.out.print(line);
		         }
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로는 존재하지 않습니다.");
		}
		if(file.exists()) {		//해당경로가 존재하면
			System.out.println(file.delete()); 	//삭제
		}
		
		
	}
}
