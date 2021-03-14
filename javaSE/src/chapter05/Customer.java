package chapter05;

public class Customer {
	private String name;
	private int age;
	private String address;
	
	public Customer() {
		this("ssafy",2,"seoul");
	}
	public Customer(String name, int age, String address) {
		this.setName(name);
		this.age = age;
		this.address = address;
	}
	
	public boolean equals(Customer cust) {
		return this == cust;
	}
	
	String customerInfo() {
		return "이름:"+getName()+"  나이:"+age+"  주소:"+address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	void test() {
		System.out.println("customer클래스의 test가 호출됨");
	}
	protected void service() {
		System.out.println("customer클래스의 service가 호출됨");
	}
	public String toString() {
		return customerInfo();
	}

}
