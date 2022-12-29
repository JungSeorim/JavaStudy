package classTest;

import java.util.*;

public class Quiz {
	//문제, 정답, 정답별 먹이개수
	String quistion;
	String ansewer;
	int feedCount;
	boolean jackpot;	//true여야 잭팟문제로 설정(Zoo클래스에서 구현함)
	
	public Quiz(){}
	
	//일반문제
	public Quiz(String quistion, String ansewer, int feedCount) {
		this.quistion = quistion;
		this.ansewer = ansewer;
		this.feedCount = feedCount;
	}
	
	
	//jackpot문제
	public Quiz(String quistion, String ansewer, int feedCount, boolean jackpot) {
		this.quistion = quistion;
		this.ansewer = ansewer;
		this.feedCount = feedCount;
		this.jackpot = jackpot;
	}
		
}