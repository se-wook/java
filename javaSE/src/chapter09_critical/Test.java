package chapter09_critical;

public class Test {

	public static void main(String[] args) {
		SyncStack stack = new SyncStack(); // 멀티 스레드에 의해 공유 되는 객체임.
		Consumer c1 = new Consumer("c1",stack);
		Consumer c2 = new Consumer("c2",stack);
		Consumer c3 = new Consumer("c3",stack);
		
		Producer p1 = new Producer("p1",stack);
		Producer p2 = new Producer("p2",stack);
		Producer p3 = new Producer("p3",stack);

		c1.start();
		c2.start();
		c3.start();
		
		p1.start();
		p2.start();
		p3.start();
	}

}
