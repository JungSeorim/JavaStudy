package anonymousTask;

public class Building {

	public static void main(String[] args) {
		
//		Starbucks gangnam = new Starbucks();		
//	      gangnam.register(new Form() {		//구현하지 않은 인터페이스를 매개변수로 받아야하는
//	    	  @Override									//상황에서 클래스처럼 new Form으로 바로 객체를 생성하고
//	    	  public String[] getMenu() {			//일회성으로 인터페이스를 선언해준다
//	    		  String[] menus = {"아메리카노", "카푸치노", "캐모마일티"};
//	    		  return menus;
//	    	  }
//	          @Override
//	          public void sell(String order) {
//	             String[] menus = getMenu();
//	             for (int i = 0; i < menus.length; i++) {
//	                if(order.equals(menus[i])) {
//	                   System.out.println("판매 완료");
//	                }
//	             }
//	          }
//	       });

		
//	잠실점 오픈
//	잠실점은 무료나눔 행사중이라서 판매방식을 구현할 필요 없다.
//	본사에서는 전달받은 양식을 검사할 때
//	무료나눔 행사중인 매장이라면 "무료나눔 행사중"출력하기
		Starbucks jamsil = new Starbucks();
		jamsil.register(new FormAdapter() {
				@Override
			public String[] getMenu() {
				String[]menus = {"아메리카노", "카푸치노", "캐모마일티"};
				return menus;
			}
				
				
		});
		
	}
}
