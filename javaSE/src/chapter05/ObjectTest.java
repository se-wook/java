package chapter05;

public class ObjectTest {

	public static void main(String[] args) throws Exception {
		Employee emp1 = new Employee("1", "ssafy", 3500000);
		Employee emp2 = new Employee("1", "ssafy", 3500000);
		Employee emp3 = (Employee)emp1.clone();
		System.out.println(emp3);
		System.out.println(emp1 == emp3 );
//		 == 는 메모리 값을 비교하기 때문에 객체는  hashcode를 비교하게 됨. 
		System.out.println(emp1 == emp2 );
		
//		객체 내용을 비교할 때는 equals(~)를 이용해서 비교해야 한다. 
		System.out.println("emp1.equals(emp2) :"+emp1.equals(emp2));
		
		System.out.printf("emp1.hashcode : %d\n", emp1.hashCode());
		System.out.printf("emp2.hashcode : %d\n", emp2.hashCode());
		System.out.printf("emp3.hashcode : %d\n", emp3.hashCode());
		
//		emp1.clone();
	}
}




