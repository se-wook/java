package chapter05;

import chapter04.Account;

public class MinusAccount extends Account {
	private int limit; // 마이너스 한도.

	public MinusAccount() {	}

	public MinusAccount(String no, String password, int balance, int limit) {
		super(no, password, balance);
		this.limit = limit;
	}
	public void setBalance(int balance) {
		System.out.println("!");
		if(balance > 0 || limit + balance >= 0) {
			this.balance = balance;
		}else {
			System.err.println("마이너스 한도 이하로 설정할 수 없습니다.");
		}
	}
	public int withdraw(String password, int amount) {
		System.out.println("?");
		boolean auth = getPassword().equals(password);
		int bal = super.getBalance();
		if(auth == true) {
			int total = bal + amount;
			if(total >= amount) {
				setBalance(bal-amount);
//				this.balance -= amount;
				return this.balance;
			}else {
				System.out.println("잔액 부족");
			}
		}else {
			System.out.println("비밀번호 오류");
		}
		return this.balance;
	}
	
	
}
