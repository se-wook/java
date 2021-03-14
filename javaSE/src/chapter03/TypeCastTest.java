package chapter03;


/**
 * 
 * @author student
 * 묵시적형변환 - 형변환이 자동으로 됨.
 * byte => short => int => long => float => double
 * 		   char
 * 
 * - 논리는 형변환이 안됨.
 * 
 * 명시적 형변환
 * (변환 타입)값;
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
