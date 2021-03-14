package chapter06;

public class SingleTonTest {

	public static void main(String[] args) {
		MySingleton s1 = MySingleton.getInstance();
		MySingleton s2 = MySingleton.getInstance();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
