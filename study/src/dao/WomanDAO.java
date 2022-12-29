package dao;

import vo.WomanVO;

public class WomanDAO {
	public static WomanVO setObject(String line) {
		String[] datas = line.split("\t");
		WomanVO womanVO = new WomanVO();
		
		womanVO.setCompanyName(datas[0]);
		womanVO.setIncome(Integer.valueOf(datas[1]));
		
		return womanVO;
	}
}
