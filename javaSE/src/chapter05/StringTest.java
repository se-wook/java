package chapter05;

public class StringTest {

	public static void main(String[] args) {
		/*String new 생성자로 객체 생성하지 않도 되는 유일한 클래스 
		 * new 생성자(~)   : heap에 일반 객체로 생성됨 
		 * String str ="" : Constance Pool에 생성됨  
		 * */
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		System.out.printf("str1 == str2 : %s\n",str1 == str2  );
		System.out.printf("str3 == str4 : %s\n",str3 == str4  );
		System.out.printf("str1 == str4 : %s\n",str1 == str4  );
		
		/*
		 * String은 Reference타입 중 유일하게 + 연산을 허용한다. 
		 * 문자열 + any Type  => 문자열에 연결하는 기능 
		 *  => 기존의 객체를 버리고 새로 생성한다. 
		 *  */
		System.out.println("hello" + 3.14);
		System.out.println("hello" + new Employee("1", "ssafy", 3500000));
		
		//1.4 추가된  split(String 구분자)  : 구분자를 기준으로 문자열으로 token 시킨다.
		String[] tokens = "hello world java ssafy".split(" ");
		for (String token : tokens) {
			System.out.println(token);
		}
		
		StringBuffer  sb1;
		StringBuilder sb2;
	}
}













