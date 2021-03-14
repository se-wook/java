package chapter09_critical;

public class Producer extends Thread {
	private SyncStack stack; // 멀티 스레드에 의해 공유되는 객체가 된다.

	public Producer(String name, SyncStack stack) {
		super(name);
		this.stack = stack;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (stack) {
				char data = (char) ('A' + Math.random() * 26);
				System.out.println(getName() + " : " + data);
				stack.push(data);
			}
		}
		System.out.println(stack);
	}
}
