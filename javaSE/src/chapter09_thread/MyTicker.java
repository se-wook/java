package chapter09_thread;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTicker extends Thread {
	
	private Frame frame;
	private Button startB, suspendB, resumeB, stopB, stateB, exitB;
	private String msg = "hello world";
	private Label msgL;
	private ActionListener handler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 이벤트가 발생된 객체
			if(startB == src) {
				start();
			}else if(suspendB == src) {
				suspend();
			}else if(resumeB == src) {
				resume();
			}else if(stopB == src) {
				stop();
			}else if(exitB == src) {
				System.exit(0);
			}
//			getState()의 상태를 추출
			System.out.println(getState());
		}
	};
	public MyTicker(ThreadGroup tg) {
		super(tg, "tg1");
		frame = new Frame("Thread 예제");
		
		startB = new Button("start");
		suspendB = new Button("suspend");
		stopB = new Button("stop");
		resumeB = new Button("resume");
		stateB = new Button("state");
		exitB = new Button("exit");
		
		Panel south = new Panel();
		south.add(startB);
		south.add(suspendB);
		south.add(stopB);
		south.add(resumeB);
		south.add(stateB);
		south.add(exitB);
		
		startB.addActionListener(handler);
		suspendB.addActionListener(handler);
		stopB.addActionListener(handler);
		resumeB.addActionListener(handler);
		stateB.addActionListener(handler);
		exitB.addActionListener(handler);
	
		msgL = new Label(msg, Label.CENTER);
		frame.add(msgL, "Center");
		frame.add(south, "South");
		frame.setBounds(500,500,350,200);
		frame.setVisible(true);
		
		
	}
	
	@Override
	public void run() {
		while(true) {
			msg = msg.substring(1) + msg.charAt(0);
			msgL.setText(msg);
			try {
				sleep(500); // 0.5초동안 thread 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		ThreadGroup mtg = new ThreadGroup(tg.getParent(),"MyThreadGroup");
		
		new MyTicker(mtg).start();
		
		for (ThreadGroup pg = tg; pg != null; pg = pg.getParent()) {
			pg.list();
			System.out.println("-------------------------");
		}
	}
	
}
