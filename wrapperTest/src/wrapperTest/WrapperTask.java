package wrapperTest;

public class WrapperTask {

	public static void main(String[] args) {
		//1, 12.5, 86.6F, 'Z', "Hi", false
		//위 6개의 값을 6칸 배열에 담기
		//Object로 묶어주기(조상클래스의 배열)
		Object[]arr= {1,12.5,86.6F,'z',"Hi",false};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	}
