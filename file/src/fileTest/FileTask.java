package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
   public static void main(String[] args) throws IOException{
//      고등어, 갈치, 꽁치, 전어 --> 0, 1, 2, 3
//      배열로 출력하고 전체 내용 가져와서 콘솔에 출력하기
      String[] fishs = {"고등어", "갈치", "꽁치", "전어"};
      
      //Writer
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));	//파일 생성
//      for (String fish : fishs) {		
//         bufferedWriter.write(fish + "\n");		//메모장에 입력해주기
//      }
//      bufferedWriter.close();		//close

      //Reader
//      try {
//         BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//         String line = null;
//         while((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//         }
//         bufferedReader.close();
//      } catch (FileNotFoundException e) {
//         System.out.println("없는 경로");
//      }

      
//      수정 (갈치 -> 연어)
//      삭제 (고등어 삭제)
      BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
     String str = null, fishA = ""; 
      while((str = bufferedReader.readLine()) != null) {
    	  if(str.equals("갈치")) {
    		  fishA += "연어";
    		  continue;
    	  }
    	  fishA += str;
      }
      
      
      
      
//      try {
//      BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//      String line = null, temp ="";
//      
//      while((line = bufferedReader.readLine()) != null) {
//         if(line.equals("고등어")) {
//            temp += "연어\n";		//고등어라면 연어로 바꿔주고 아래무시(continue)
//            continue;
//         }
//         temp += line + "\n";			//갈치가 아니라면 그대로
//      }
//      
//      bufferedReader.close();
//      
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//      bufferedWriter.write(temp);
//      bufferedWriter.close();
//      
//   } catch (FileNotFoundException e) {
//      System.out.println("없는 경로입니다.");
//   }

      
   }
}