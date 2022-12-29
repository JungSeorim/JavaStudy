package lamp;
//전원을 꺼주는 스레드
import java.time.LocalDateTime;
import java.util.StringJoiner;
import java.util.Timer;

import bakery.BreadPlate;

/**
 * 전원 끄기 예약이 가능한 책상 조명
 */
public class TimerDeskLamp extends DeskLamp implements Runnable{
	
    final static int DELAY_MILLISECOND = 5000;	//5초 후에 꺼지도록

    //private 기본생성자
    private TimerDeskLamp() {}

    //싱글톤패턴
    private Thread offDelayThread; // 전원 끄기 예약 쓰레드
    private Thread previousThread;
        
    //예약 중에 
    //예약하기
    public void offDelay() {
    	if(previousThread != null) {				//현재 진행중인 스레드가 있다면
    		previousThread.interrupt(); 			//중단한다?
    	}
        offDelayThread = new Thread(this);
        offDelayThread.start();		//중단하고 재시작?
        previousThread = offDelayThread;
    }

    @Override
    public void run() {
    	while(true) {			//timer가 계속 돌다가 
	    		//true 전원이 켜진상태, 끄는 타이머
	    	try {Thread.sleep(DELAY_MILLISECOND);} 	// 5초 후 sleep
	    	catch (InterruptedException e) {
	    	System.out.println("Timer Reset");
	    	break;
	    	}
		  turnOff();
	    break;
	    }
    };
}
