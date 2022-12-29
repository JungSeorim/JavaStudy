//여러 개의 정수를 입력받아서 알맞는 덧셈, 뺄셈 결과를 확인하는 애플리케이션 제작
//
//입력 예1) 7 + 35 - 9
//출력 예1) 33
//
//입력 예2) -9 + 8 + 10
//출력 예2) 9
//
//* "ABC".split("")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//  "A,B,C".split(",")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//  split("구분점")을 전달하면 문자열에서 동일한 구분점을 기준으로 문자열 값을 잘라낸 후 문자열 배열로 리턴한다.
//  구분점을 여러 개 사용할 때에는 split("구분점|구분점")으로 사용하며, "+","-"를 구분점으로 사용할 때에는 "\\+", "\\-"로 표현한다. 
//
//* 사용자가 정상적으로만 입력한다는 가정 하에 구현하도록 한다.
//* 두 정수를 전달받은 후 int로 리턴하는 calc 추상메소드 선언(함수형 인터페이스 제작)
//* 두 정수의 덧셈, 뺄셈을 구해주는 함수형 인터페이스를 리턴하는 static 메소드 선언(람다식 리턴)
//* 전체 식을 전달받은 후 String[]로 리턴하는 getOpers 추상메소드 선언(함수형 인터페이스 제작)
//* main메소드에 getOper를 람다식으로 구현
//* 첫번째 정수가 음수일 경우 오류 해결

package lamdaTask;

import java.util.Scanner;

public class MyMath {
//   외부에서 연산자 한 개를 전달받는다.
   public static Calc calculator(String oper) {
      Calc c = null;
      
      switch(oper) {
      case "+" : // 전달받은 연산자가 +일 때
         c = (n1, n2) -> n1 + n2;
         break;
      case "-" :
         c = (n1, n2) -> n1 - n2;
         break;
      }
      
      return c;
   }
   public static void main(String[] args) {
//      전체 수식에서 +와 -만 분리하는 메소드로 구현
      OperCheck operCheck = (ex) -> {
         String temp = "";
               
         //전체 수식에서 연산자만 골라서 문자열에 담고
         for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            if(c == '-' || c == '+') {
               temp += c;
            }
         }
         //문자열 배열로 리턴
         return temp.split("");
      };
      
      String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요.";
      String exampleMessage = "예)9+7-5";
      String expression = null;
      String[] opers = null;
      String[] nums = null;
      int number1 = 0, number2 = 0;
      
      Scanner sc = new Scanner(System.in);
      
      System.out.println(msg);
      System.out.println(exampleMessage);
      //사용자에게 전체 수식을 입력받는다.
      expression = sc.next();
//      위에서 구현한 연산자 추출 메소드에 전체 수식을 전달한다.
      opers = operCheck.checkOper(expression);
      nums = expression.split("\\+|\\-");		
      // 입력값을 +와 =를 분기점으로 구분하여 num배열에 넣어주겠다
      
//      -1+9+5
//      nums[0] = nums[0].equals("") ? "0" : nums[0];
      
      number1 = Integer.parseInt(nums[0].equals("") ? opers[0] + nums[1] : nums[0]);
      
      for (int i = 0; i < opers.length; i++) {
         if(i == 0 && number1 < 0) {continue;}
         number2 = Integer.parseInt(nums[i + 1]);
         number1 = calculator(opers[i]).calc(number1, number2);
      }
      
      System.out.println(number1);
   }
}
