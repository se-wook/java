package chapter09_thread;

public class ThreadTest4 {
	public static void main(String[] args) {
		MyRunnable job = new MyRunnable();
		
		
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		
		t1.start();
		try {
			/*
			 * join은 현재 코드를 동작 시켜주는  Thread는 join()를 호출한 Thread가 동작이 끝날 때 까지
			 * block된다.
			 */
			
			t1.join(); // main Thread가 t1에 join되서 멈춘 상태.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		t3.start();
		System.out.println("main end");
	}
}	
