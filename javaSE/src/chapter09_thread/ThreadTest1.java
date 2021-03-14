package chapter09_thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		
//		t1.start(); // thread를 동작시켜주는 함수
//		t2.start();
//		t3.start(); 
		t1.run(); // 일반 메서드 호출 -> main 을 동작시켜주는 thread에 의해 수행됨.
		t2.run();
		t3.run();		
		System.out.println("main end");
	}
}	
