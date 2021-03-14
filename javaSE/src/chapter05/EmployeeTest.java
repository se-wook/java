package chapter05;

public class EmployeeTest {
	public static void main(String[] args) {
//		EmployeeManager manager = new EmployeeManager();
		EmployeePolyManager manager = new EmployeePolyManager();
		
		manager.add(new Employee("1", "홍길동", 2500000));
//		manager.add(new Employee("1", "홍길동", 2500000));
		manager.add(new Manager("2", "길동홍", 3500000,"대리"));
		manager.add(new Engineer("3", "고길동", 3000000,"java"));
		System.out.println("================등록 후 결과================");
		manager.print();
		System.out.println("================수정 후 결과================");
		manager.update(new Engineer("1", "홍길동", 3000000,"backEnd"));
		manager.print();
		System.out.println("================삭제 후 결과================");
		manager.remove("1");
		manager.print();

		System.out.println("================검색 결과================");
		System.out.println(manager.findEmployee("1"));
		System.out.println(manager.findEmployee("2"));
		System.out.println(manager.findEmployee("3"));
		System.out.println(manager.findEmployee("4"));
	}
}





