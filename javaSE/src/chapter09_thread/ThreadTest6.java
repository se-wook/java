package chapter09_thread;
/**
 * MyRunnable3
 */
public class ThreadTest6 {
	public static void main(String[] args) {
		MyCount cnt = new MyCount();
		MyRunnable3 job = new MyRunnable3(cnt);
		
		Thread t1 = new Thread(job, "t1");
		Thread t2 = new Thread(job, "t2");
		Thread t3 = new Thread(job, "t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}
}	
