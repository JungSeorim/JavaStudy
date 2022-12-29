package anonymousTask;

public class Starbucks{
	
   public void register(Form form) {
      String[] menus = form.getMenu();
      
      System.out.println("=======메뉴========");
      for (int i = 0; i < menus.length; i++) {
         System.out.println(i + 1 + ". " + menus[i]);
      }
      
      form.sell("카푸치노");
   }
  
}