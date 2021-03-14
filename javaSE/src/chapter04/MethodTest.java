package chapter04;

public class MethodTest {
	public static int plus(int i, int j) {
		return i+j;
	}
	/**
	 * 
	 */
	private static double plus(double d, double e) {
		return d+e;
	}
	public static void main(String[] args) {
		System.out.println(plus(256.5,128.4));
	}

}
