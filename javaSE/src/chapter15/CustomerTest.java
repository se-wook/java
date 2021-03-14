package chapter15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import chapter05.Customer;

public class CustomerTest {
	 public static void main(String[] args) {
		List<Customer> custs = CustomerSAXParsing.getContents("res/customerlist.xml");
		for(Customer cust : custs) {
			System.out.println(cust);
		}
	}
}
