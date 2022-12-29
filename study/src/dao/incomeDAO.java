package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.ManVO;
import vo.WomanVO;

public class incomeDAO {

	public ArrayList<ManVO> man;
	public ArrayList<WomanVO> woman;
	
	//병합
	public void merge(String path1, String path2, String path3)throws IOException {
		BufferedReader manReader = DBConnecter.getReader(path1);
		BufferedReader womanReader = DBConnecter.getReader(path2);
		BufferedWriter bufferedWriter = null;
		
		ManDAO mandao = new ManDAO();
		WomanDAO girldao = new WomanDAO();
		
		man = new ArrayList<ManVO>();
		woman = new ArrayList<WomanVO>();
		
		String line = null, temp = "";
	
		
		while((line = manReader.readLine()) != null) {
			temp += line + "\n";
			man.add(ManDAO.setObject(line));
		}
		
		manReader.close();
		
		while((line = womanReader.readLine()) != null) {
			temp += line + "\n";
			woman.add(WomanDAO.setObject(line));
		}
		
		womanReader.close();
		
		bufferedWriter = DBConnecter.getWriter(path3);
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}

	// 순위 매기기
	public void updateRanking(String path) throws IOException{
		
	}
	
}
	
