package chapter03;

public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ������ �⺻���� int
		 * byte, short�� ����� �ڵ����� int�� ����ȯ�ȴ�.
		 */
		byte b1 = 3, b2 = 5;
//		byte b3 = b1 + b2;
		
//		long l1 = 2222222222; //int ���� �̻��� ���ڸ� long�� �����ϰ�ʹٸ�, ����� longŸ��(l, L)�̶�� ǥ���ؾ��Ѵ�.
		long l2 = 2222222222l;
		
		float f1 = 3.14f, f2 = 3.14F; // float���� ǥ���ؾ��Ѵ�.
		float f3 = 65536.256f;
		System.out.println("f3: "+f3);
	
		double d1 = 3.14, d2 = 3.14d, d3 = 3.14D;
		double d4 = 1.2345678901234567890;
		System.out.println(d4);
		
		char c1 = 'a';
		
		boolean bl1 = true; // 0,1 �� ǥ�� �Ұ�.
		
	}
}
