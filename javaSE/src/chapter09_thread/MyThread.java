package chapter09_thread;

public class MyThread extends Thread {
	private int i;
	
	public MyThread(String name) {
//		Thread 이름 설정, Thread 이름을 생략하면  Thread-01 부터 순차적으로 이름이 부여된다.
		super(name);
	}
	
	/** Thread에 의해 병행처리 될 함수 => 멀티 프로그램으로 동작할 기능*/
	public void run() {
		for(i=0;i<50;i++) {
//			Thread.currentThread() : 현재 코드를 동작시켜주는 Thread를 추출
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				sleep(300);
			}catch(Exception e) {
				
			}
		}
	}
}
