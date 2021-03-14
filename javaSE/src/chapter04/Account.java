package chapter04;

public class Account {
	private String no;
	private String password;
	protected int balance; // 패키지가 달라도됨.


	public Account() {
	}

	public Account(String no, String password, int balance) {
		setNo(no); // 컴파일러가 알아서 optimize 한다.  
		setPassword(password);
		setBalance(balance);
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance > 0) {
			this.balance = balance;
		}else {
			System.err.println("마이너스 출금이 안되는 계좌입니다.");
		}
	}
	
	public int deposit(int amount) {
		this.balance += amount;
		return this.balance;
	}

	public int withdraw(String password, int amount) {
		boolean auth = this.password.equals(password);
		if (auth == true) {
			if (this.balance >= amount) {
				this.balance -= amount;
				return this.balance;
			} else {
				System.out.println("잔액 부족");
			}
		} else {
			System.out.println("비밀번호 오류");
		}
		return this.balance;
	}
}
