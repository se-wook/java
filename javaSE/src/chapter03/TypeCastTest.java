package chapter03;


/**
 * 
 * @author student
 * ����������ȯ - ����ȯ�� �ڵ����� ��.
 * byte => short => int => long => float => double
 * 		   char
 * 
 * - ���� ����ȯ�� �ȵ�.
 * 
 * ����� ����ȯ
 * (��ȯ Ÿ��)��;
 */
public class TypeCastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 3, b2 = 5;
		byte b3 = (byte) (b1 + b2);
		
		int i1 = b1 + b2;
		
		long l1 = 2222222222l;
		float f1 = l1;
		
		double d1 = f1;
		System.out.println(f1);
	}

}
