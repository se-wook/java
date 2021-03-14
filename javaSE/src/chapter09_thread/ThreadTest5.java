package chapter09_thread;

public class ThreadTest5 {
	public static void main(String[] args) {
		MyRunnable2 job = new MyRunnable2();
		
		Thread t1 = new Thread(job, "t1");
		Thread t2 = new Thread(job, "t2");
		Thread t3 = new Thread(job, "t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}
}	
