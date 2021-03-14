package chapter04;

import java.util.Calendar;

public class MyDate {
	private int year, month, date;
	private Calendar today = Calendar.getInstance();

	public MyDate() {
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;
		date = today.get(Calendar.DATE);
	}

	public MyDate(int year, int month, int date) {
		setYear(year);
		setMonth(month);
		setDate(date);
	}
	
	public void setYear(int year) {
		if (year >= 2018) {
			this.year = year;
		} else {
			System.err.println("2018년 이후로 설정하세요!");
			this.year = today.get(Calendar.YEAR);
		}
	}

	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			System.err.println("1월부터 12월 사이로 설정하세요!");
			this.month = today.get(Calendar.MONTH) + 1;
		} else {
			this.month = month;
		}
	}

	public void setDate(int date) {
		// 1,3,5,7,8,10,12 월은 31일
		// 4,6,9,11 월은 30일
		// 2월은 28일까지
		if (date < 1 || date > 31) {
			System.err.println("날짜를 1일부터 31일사이로 설정하세요.");
			this.date = today.get(Calendar.DATE);
		} else {
			if (isValid(date)) {
				this.date = date;
			} else {
				System.err.printf("%d일은 %d월에 설정할 수 없는 날짜입니다. ", date, month);
				this.date = today.get(Calendar.DATE);
			}
		}

	}
	
	public void setDate(int year, int month, int date) {
		setYear(year);
		setMonth(month);
		setDate(date);
	}
	
	public String toString() {
		return year+"년" + month + "월" + date + "일"; 
	}

	private boolean isValid(int date) {
		if ((month == 2 && date > 28) || ((month == 4 || month == 6 || month == 9 || month == 1) && date > 30)) {
			return false;
		}
		return true;

	}
}
