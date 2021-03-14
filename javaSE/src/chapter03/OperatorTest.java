package chapter03;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// >> : sign bit를 유지하면서 오른쪽으로 1비트 이동
		int n1 = 8;
		int n2 = -8;
		
		System.out.println("8 >> 1 : " + (n1 >> 1));
		System.out.println("-8 >> 1 : " + (n2 >> 1));
		// >>> : 오른쪽으로 1비트 이동, 왼쪽에는 0이 채워짐
		System.out.println("8 >>> 1 : " + (n1 >>> 1));
		System.out.println("-8 >>> 1 : " + (n2 >>> 1));

		// << : sign bit를 유지하면서 왼쪽으로 1비트 이동, 오른쪽에는 0이 채워짐
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
		 * %d : 정수		%f : 실수		%.자리수f : 실수의 소수 자리수 표현
		 * %s : 문자열	%c : 문자
		 * %b : 논리 
		 */
		System.out.printf("result :%b, i>%d, j>%d",result, i,j);
		
		
	}
}
