package dao;

import vo.ManVO;

public class ManDAO {
	public static ManVO setObject(String line) {
		String[] datas = line.split("\t");
		ManVO manVO = new ManVO();
		
		manVO.setCompanyName(datas[0]);
		manVO.setIncome(Integer.valueOf(datas[1]));
		
		return manVO;
	}
	
}
