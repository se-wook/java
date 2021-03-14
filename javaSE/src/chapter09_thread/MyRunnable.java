package chapter09_thread;

public class MyRunnable implements Runnable {
	private int i;
	
	@Override
	public void run() {
		for(i=1;i<=50;i++) {
			System.out.println(Thread.currentThread().getName()+ " : " + i);
		}
	}
}
