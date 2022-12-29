package arrayListTask;

import java.util.ArrayList;

public class Restaurant {
//  음식 정보를 담을 DB 선언
	   public ArrayList<Food> data = new ArrayList<Food>();
	   
//  음식 추가
	   public void addFood(Food food) {	//음식을받아서
		   //저장할 곳은 ArrayList data.
		   data.add(food);
	   }
  
//  양식인지 중식인지 일식인지 한식인지 검사(문자열로 리턴) 
//  예)스파게티 입력 시 "양식"리턴
	   public String checkKind(String foodName) {
		   String type = null;
		   Food food = null;
		   for (int i = 0; i < data.size(); i++) {
			   if(food.getName().equals(foodName)) {
				   type = food.getKind();
				   return type;
			   }
		}
		   return null;
	   }
	   
//  사용자가 원하는 종류의 음식 목록 조회(종류는 한 가지만 입력가능)
//  예)한식 입력 시 한식만 조회
	   public ArrayList<Food> checkOneType(String foodKind) {	//중식
		   ArrayList<Food> menus = new ArrayList<>();
		   //입력받은 음식의 종류와 중복되는 값 찾기
		   for (int i = 0; i < data.size(); i++) {
			if(foodKind.equals(data.get(i).getKind())) {
				menus.add(data.get(i));
			}
		}
		   //한 종류의 음식을 정보까지 모두 가져오기
		   return menus;
	   }
	   
  
//  음식의 종류 수정(가격 10% 상승)
//  예)한식 -> 중식, 음식 가격은 10% 상승
//	   public ArrayList<Food> modifyType(String originalType, String changeType) {
//		   ArrayList <Food> check = new ArrayList<>();		//바뀐 음식정보 (가격, 종류)
//		   check = checkOneType(originalType);		//한 종류의 음식을 (ArrayList)로 모두 받아와서
//		   for (int i = 0; i < data.size(); i++) {
//			   check.get(i).setPrice((int)(check.get(i).getPrice()*1.1));
//			   check.get(i).setKind(changeType);			//바꿔준다
//		}
//		   return check;
//	   }
//	  public String modifyType(String originalType, String changeType ) {	//바꿀 음식종류를 입력받고
//		  String modifiedType = null;
//		  String modifiedFood = null;
//		  int newPrice =0;
//		  for (int i = 0; i < data.size(); i++) {
//			  if(originalType.equals(data.get(i).getKind())) {
//				  modifiedFood = data.get(i).getName()+modifiedFood;
//				  modifiedType = data.get(i).setKind(changeType)+modifiedType;
//				  newPrice = (int)(data.get(i).setPrice((data.get(i).getPrice())*1.1));
//			  }
//		}
//		  return modifiedType + ", "+modifiedFood+", "+ newPrice;	//메뉴와 가격반환
//	  }
	   //매개변수 부분은 이미 수정된 값으로 들어옴
	   //다시
	   public void updateKinds(Food food) {
		   for (Food temp : data) {
			if(temp.getName().equals(food.getName())) {
				temp.setKind(food.getKind());
				temp.setPrice(temp.getPrice() * 1.1);
				break;
			}
		}
	   }
	   
	   
  
//  사용자가 원하는 종류의 음식 개수 조회
//  예) 불고기, 제육볶음, 파스타, 초밥
//  한식 입력 시 2개
//	   public int countFood(String foodKind) {
		   //원하는 종류의
		   //개수는?
//		   int count = 0;
//		   for (int i = 0; i < data.size(); i++) {
//			if(foodKind.equals(data.get(i).getKind())) {
////				++count;		//전위형을 쓰면 혼란을 줄수있음
//				count++;
//			}
//		}
//		   return count;
//		   return checkKind(foodKind).size();		//이거 하나면 됨
//	   }
	   
	   
	   
	   
	   public static void main(String[] args) {
		   Food dish1 = new Food();
		   Food dish2 = new Food();
		   Food dish3 = new Food();
		   Restaurant menu = new Restaurant();

		   //음식정보 추가
		   dish1.setName("짜장면");
		   dish1.setPrice(6000);
		   dish1.setKind("중식");
		   dish2.setName("탕수육");
		   dish2.setPrice(15000);
		   dish2.setKind("중식");
		   dish3.setName("깐풍기");
		   dish3.setPrice(18000);
		   dish3.setKind("중식");
		   
		   //해당 음식 식당메뉴에 추가
		   menu.addFood(dish1);	
		   menu.addFood(dish2);	
		   menu.addFood(dish3);	
		   
		   //짜장면은 무슨종류 ? 
		   System.out.println(menu.checkKind("짜장면"));
		   System.out.println(menu.checkKind("탕수육"));
		   System.out.println(menu.checkKind("깐풍기"));
		   
		   //중식엔 어떤음식?
		   System.out.println(menu.checkOneType("중식"));
		   
		   //음식 타입바꿔주기
//		   System.out.println(menu.modifyType("중식", "한식"));
	
		   //원하는 음식종류의 총 개수
//		   System.out.println(menu.countFood("한식"));
	}
}
