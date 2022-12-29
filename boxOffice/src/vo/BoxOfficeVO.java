package vo;

public class BoxOfficeVO {
	private int ranking;
	private String name;
	private String releaseDate;
	private long income;
	private int guestCount;
	private int screenCount;
	
	public BoxOfficeVO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public void setScreenCount(int screenCount) {
		this.screenCount = screenCount;
	}
	
	private String insertComma(String data) {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			if( i%3==0) {
	            result = "," + result;
			}
			result += data.charAt(data.length()-1 -i) + result;
		}
		return result;
	}
	
//	숫자타입은 3자리마다 , 삽입	
//	뒷자리부터 출력하고 i가 3의 배수 일때마다 콤마를 붙인다
	@Override
	public String toString() {
//		기존의 값을 배열로 받는다
		String str = null;
		String incomeWithComma = String.valueOf(guestCount);
		for (int i = 0; i < incomeWithComma.length(); i++) {
//		마지막 인덱스부터 숫자를 출력해주면서 콤마를 찍어준다 ( 앞에부터 찍으면 맞지않음)
		}
		 str = ranking + "\t" + name + "\t" + releaseDate + "\t" 
		            + insertComma(String.valueOf(income)) + "\t" 
		            + insertComma(String.valueOf(guestCount)) + "\t" 
		            + insertComma(String.valueOf(screenCount));
		 return str;
	}
}