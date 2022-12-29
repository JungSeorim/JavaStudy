package vo;

public class IncomeDTO {
	 private String companyName;
	 private int income;
	 private int ranking;
		 
	 public IncomeDTO() {;}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
		
	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		String str = income+"\t"+companyName+"\t"+income;
		return str;
		}
}