package chapter04;

import chapter05.MinusAccount;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Account ac = new Account("1","1234",50000);
		MinusAccount ac = new MinusAccount("1","1234",50000,1000000);
		
		System.out.println(ac.deposit(10000));
		System.out.println(ac.withdraw("1234", 10000));
		System.out.println(ac.withdraw("19999", 1000));
		System.out.println(ac.withdraw("1234", 10000000));
		
	}

}
