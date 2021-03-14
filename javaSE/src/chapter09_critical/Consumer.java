package chapter09_critical;

public class Consumer extends Thread {
	private SyncStack stack; // 멀티 스레드에 의해 공유되는 객체가 된다.	
	
	public Consumer(String name, SyncStack stack) {
		super(name);
		this.stack = stack;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (stack) {
				System.out.println(getName() + " : " + stack.pop());
				
			}
		}
		System.out.println(stack);
	}
}
