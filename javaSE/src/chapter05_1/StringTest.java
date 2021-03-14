package chapter05_1;

public class StringTest {
	public static void main(String[] args) {
		/**
		 * String 
		 *  - new 생성자로 객체 생성하지 않아도 되는 유일한 클래스
		 *  - new로 생성 		  : heap에 일반 객체로 매번 생성됨.
		 *  - String str = "" : Constance Pool(상수 풀)에 한번 생성됨.
		 */
		// "hello"라는 객체를 참조하는 str1 변수
		// 쌍따옴표 자체가 객체다.
		String str1 = "hello";
		String str2 = "hello"; 
		//str3 은 hashcode가 들어있는 변수.
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.println(str1 == str2); // hashcode가 같음
		str1 = "h";
		System.out.println(str2); // 안변하네 ㄷㄷ
		System.out.println(str3 == str4);
		
		/**
		 * String은 Reference 타입 중 유일하게 + 연산을 허용한다.
		 * 문자열 + any Type => 문자열에 연결하는 기능.ㅎ
		 *  => 문제점 : 기존의 객체를 버리고 새로 생성해서 가비지가 생김.
		 */
		System.out.println("hello " + 3.14);
		System.out.println("hello " + new Employee("1","ssafy",35044444));
		
//		1.4버전에 추가된 split(String 구분자) : 구분자를 기준으로해서 문자열을 잘라줌.
		String[] tokens = "hello world java ssafy".split(" ");
		
		//구현부 메소드에 syncronized가 붙었다.
		StringBuffer buffer;
		
		//synchronized가 안붙음.
		StringBuilder builder;
	}
}
