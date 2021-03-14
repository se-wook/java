package chapter03;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// >> : sign bit�� �����ϸ鼭 ���������� 1��Ʈ �̵�
		int n1 = 8;
		int n2 = -8;
		
		System.out.println("8 >> 1 : " + (n1 >> 1));
		System.out.println("-8 >> 1 : " + (n2 >> 1));
		// >>> : ���������� 1��Ʈ �̵�, ���ʿ��� 0�� ä����
		System.out.println("8 >>> 1 : " + (n1 >>> 1));
		System.out.println("-8 >>> 1 : " + (n2 >>> 1));

		// << : sign bit�� �����ϸ鼭 �������� 1��Ʈ �̵�, �����ʿ��� 0�� ä����
		System.out.println("8 << 1 : " + (n1 << 1));
		System.out.println("-8 << 1 : " + (n2 << 1));
		
		
		/* 
		 * 					&&		&		||		|
		 * false false		false	false	false	false
		 * false true		false	false	true	true
		 * true false		false   false	true	true
		 * true true		true	true	true	true
		 */
		int i=10,j=5;
		boolean result = i++ > 10 & j++ > 5;
		
		/*
		 * %d : ����		%f : �Ǽ�		%.�ڸ���f : �Ǽ��� �Ҽ� �ڸ��� ǥ��
		 * %s : ���ڿ�	%c : ����
		 * %b : �� 
		 */
		System.out.printf("result :%b, i>%d, j>%d",result, i,j);
		
		
	}
}
