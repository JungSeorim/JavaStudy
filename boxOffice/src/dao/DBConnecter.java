package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	public static final String PATH = "boxOffice.txt";
	
	//외부와 연결하는 객체는 BufferedWriter & Reader
	//파일 덮어쓰기
	public static BufferedWriter getWriter() throws IOException{
		return new BufferedWriter(new FileWriter(PATH));
	}
	
	//파일 이어쓰기
	public static BufferedWriter getAppend() throws IOException{
		return new BufferedWriter(new FileWriter(PATH, true));
	}
	
	//파일 읽기
	public static BufferedReader getReader() throws IOException{
		return new BufferedReader(new FileReader(PATH));
	}
}
