package chapter04;

class MyAccess {
	private String name;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void callName() {
		System.out.println(this.getName());
	}
}

public class AccessModifierTest {

	public static void main(String[] args) {
		MyAccess a = new MyAccess();
		
		Account ac = new Account();
		
		chapter03.DataTypeTest.main(null);
	}

}
