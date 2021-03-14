package chapter05_1;

public class Employee implements Cloneable, Comparable<Employee>{
	private String empno, name;
	private int salary;
	
	public Employee() {	}
	
	public Employee(String empno, String name, int salary) {
		setEmpno(empno);
		setName(name);
		setSalary(salary);
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if(salary < 1000000) {
			System.out.println("급여는 100만원 미만일 수 없습니다.");
			this.salary = 1000000;
		}else {
			this.salary = salary;
		}
	}
	
	/**
	 * 객체의 내용을 문자열로 리턴해주는 기능.
	 * -System.out으로 객체를 출력할 때 toString()이 호출된다.
	 * -(문자열+객체)를 출력해도해도 객체의 toString()이 호출돼서 문자열에 연결된다.
	 * -override 하지 않으면 "클래스이름@hashcode" 가 리턴된다.
	 * -필요시 override
	 * 
	 */
	
//	public String toString() {
//		super.toString();
//		return "사원번호:" + empno + " 이름:" + name + " 급여:" + salary;
//	}	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("[empno=").append(empno).append(", name=").append(name).append(", salary=")
		.append(salary).append("]");
		return builder.toString();
	}
	
	/**
	 * 객체의 내용을 비교하는 기능
	 * - 반드시 override 해야 객체 내용을 비교할 수 있다.
	 * - 
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if(empno!= null && empno.equals(emp.empno)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * hashcode : 객체의 참조값을 리턴하는 기능.
	 * - 필요시 override
	 * - override를 해도 객체의 실제 hashcode는 변하지 않는다.
	 * 
	 */
	public int hashCode() {
		int empnoHash = this.empno != null ? empno.hashCode() : 1;
		int nameHash = this.name != null ? name.hashCode() : 1;
		//연산은 의미없음 , 같은연산이니까 같은 값이면 같은값이 리턴된다는 것을 의미.
		return empnoHash ^ nameHash ^ salary; 
	}
	
	/**
	 * 객체의 내용이 똑같은 객체를 생성해서 리턴.
	 * - Object에서 protected로 선언했기 떄문에 함수를 사용하려면 반드시 override 해야한다.
	 * - 규칙 
	 * 	 1. Cloneable 인터페이스를 implements 해야한다. 
	 * 		=> 안지키면 CloneNotSupportedException 
	 * @throws CloneNotSupportedException 
	 */
	protected Object clone() throws CloneNotSupportedException {
//		여기서는 그냥 super.clone() 만 리턴 해주면됨.
		return super.clone();
	}

	
	/**
	 * 앞 -1 뒤 +1
	 */
	@Override
	public int compareTo(Employee o) {
		/** STRING 기준*/
//		if(empno != null && o != null && o.empno != null) {
////			오름차순 : 현재 객체 - 인자로 전달된 객체
////			내림차순 : 인자로 전달된 객체 - 현재 객체
////			return empno.compareTo(o.empno); // 오름차순
//			return o.empno.compareTo(empno); // 내림차순
//		}
		
		/** INT 기준*/
		if(o != null) {
			return o.salary - salary;
		}
		return 0;
	}	
}
