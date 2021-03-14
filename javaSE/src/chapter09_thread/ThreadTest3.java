package chapter09_thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		MyRunnable job = new MyRunnable();
//		Thread상속은 ref만 공유 가능인데..
		
		
//		ref + primitive 타입까지 공유 가능.
		Thread t1 = new Thread(job, "t1");
		Thread t2 = new Thread(job, "t2");
		Thread t3 = new Thread(job, "t3");
		
//		reference type만 공유 가능
//		Thread t1 = new Thread(new MyRunnable(), "t1");
//		Thread t2 = new Thread(new MyRunnable(), "t2");
//		Thread t3 = new Thread(new MyRunnable(), "t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}
}	
