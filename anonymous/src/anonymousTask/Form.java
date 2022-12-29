package anonymousTask;

//잠실점 오픈
//잠실점은 무료나눔 행사중이라서 판매방식을 구현할 필요 없다.

//본사에서는 전달받은 양식을 검사할 때
//무료나눔 행사중인 매장이라면 "무료나눔 행사중"출력하기 이걸 어디다 선언해줘야할까?

public interface Form {
	public String[]getMenu();
	public void sell (String order);
}
