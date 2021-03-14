package chapter09_thread;

public class ThreadTest2 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		
		
//		윈 7부터는 RoundRobbin이라 우선순위 적용 안된다. 리눅스는 우선순위 먹음.
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
//		t2 는 기본 priority인 NORM_PRIORITY = 5.
		
		t1.start(); // thread를 동작시켜주는 함수
		t2.start();
		t3.start(); 
		
		
		System.out.println("main end");
	}
}	
