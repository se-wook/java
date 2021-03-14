package chapter09_thread;

class MyCount {
	private int i = 0;	
	public int inc() {
		return ++i;
	}
	
}

public class MyRunnable3 implements Runnable {
	private MyCount cnt;
	
	public MyRunnable3(MyCount cnt) {
		this.cnt = cnt;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (cnt) {
				int i= cnt.inc();
				System.out.println(Thread.currentThread().getName() + " : " + i);
				if(i>=50) {
					break;
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
			}
		}
	}
}
