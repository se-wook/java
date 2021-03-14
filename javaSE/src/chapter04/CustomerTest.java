package chapter04;

public class CustomerTest {

	public static void main(String[] args) {
		Customer cs = new Customer();
		cs.name = "asdf";
		cs.age = 19;
//		cs.address = "?>";
		System.out.println(cs.customerInfo());
		
		Customer cs2 = new Customer();
		System.out.println(cs2.customerInfo());
		
		
		System.out.println(cs.equals(cs));
	}

}
