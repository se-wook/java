package chapter09_critical;

import java.util.ArrayList;
// 3. 동기화, 멈춰야할 때 wait() (lock flag를 반납하고 wait) 데이터가ㅣ 추가되면 notify()
public class SyncStack {
	private ArrayList<Character> stack;
	private Thread t1;
	public SyncStack() {
		stack = new ArrayList<>(150);
		
	}
	public void push(char data) {
		this.notify();
		stack.add(data);
	}
	public char pop() {
		char data = ' ';
		while(stack.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				
			}
		}
		data = stack.remove(stack.size()-1);
		return data;
	}
	public synchronized String toString() {
		return stack.toString();
	}
	
}
// 2. 동기화, 데이터가 없는 경우에 suspend, 데이터가 추가된 경우에 resume.
//    => 동기화 된 상황에서 suspend()를 호출하면 lock flag 를 가지고 block되기 때문에
//       DeadLock이 된다.
//public class SyncStack {
//	private ArrayList<Character> stack;
//	private Thread t1;
//	public SyncStack() {
//		stack = new ArrayList<>(150);
//		
//	}
//	public void push(char data) {
//		stack.add(data);
//		t1.resume();
//	}
//	public char pop() {
//		char data = ' ';
//		if(stack.size() == 0) {
//			t1 = Thread.currentThread();
//			t1.suspend(); //lock flag를 들고 들어감.
//		}
//		data = stack.remove(stack.size()-1);
//		return data;
//	}
//	public synchronized String toString() {
//		return stack.toString();
//	}
//	
//}
// 1. 동기화가 안되서 데이터 공유에 문제가 있고 
// 데이터가 없는 상황에서 멈춰야 하는데 계속 수행되서 문제 발생.
//public class SyncStack {
//	private ArrayList<Character> stack;
//	
//	public SyncStack() {
//		stack = new ArrayList<>(150);
//		
//	}
//	public void push(char data) {
//		stack.add(data);
//	}
//	public char pop() {
//		char data = ' ';
//		try {
//			data = stack.remove(stack.size()-1);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return data;
//	}
//	public String toString() {
//		return stack.toString();
//	}
//	
//}
