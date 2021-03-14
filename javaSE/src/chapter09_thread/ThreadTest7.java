package chapter09_thread;
/**
 * MyRunnable3
 */
public class ThreadTest7 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		/**
		 * Daemon Thread
		 * : Master Thread가 종료되면 Daemon Thread도 종료된다.
		 */
		t1.setDaemon(true); //현재 코드를 수행시켜주는 Thread가 Master가 되도록 daemon 설정.
		t1.start();
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		 System.out.println(">??");
		 
	}
}	
