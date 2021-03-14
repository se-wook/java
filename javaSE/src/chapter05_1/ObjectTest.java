package chapter05_1;

public class ObjectTest {
	public static void main(String[] args) throws Exception {
		Employee e1 = new Employee("1", "ssafy", 3500000);
		Employee e2 = new Employee("1", "ssafy", 3500000);
		Employee e3 = (Employee) e1.clone();

//		== 기호는 메모리 값을 비교하기 때문에 객체는 hashcode를 비교하게됨.
		System.out.println(e1 == e2); // false : hashcode가 각각 다르기 때문에 거짓.

//		객체 내용 비교시에는 equals() 메소드를 이용해서 비교해야 한다.
		System.out.println(e1.equals(e2)); // + override 해서 사용해야 true 나옴.

//		객체가 다르면 hashcode도 다르쥬 // override해서 같아 '보이게' 할수는 있다.
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

		
//		hashcode는 다른 또 하나의 객체로 복제가 되었다.
		System.out.println(e3);
		System.out.println(e1 == e3);		
		System.out.println(e1.hashCode());
		System.out.println(e3.hashCode());

	}
}
