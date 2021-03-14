package chapter05;

public class AccountTest {
	public static void main(String[] args) {
		MinusAccount  account = new MinusAccount("1", "1111", 10000, 100000);
		account.setBalance(-110000);
		System.out.println("입금 후 잔액 :"+account.deposit(5000));
		System.out.println("출금 후 잔액 :"+account.withdraw("1212", 20000));
		System.out.println("출금 후 잔액 :"+account.withdraw("1111", 20000));
		System.out.println("출금 후 잔액 :"+account.withdraw("1111", 10000));
	}
}
