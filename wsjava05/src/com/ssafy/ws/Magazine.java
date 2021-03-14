package com.ssafy.ws;

public class Magazine extends Book{
	private int year, month;
	public Magazine() {	}
	
	public Magazine(String isbn, String title, String author, String publisher, String desc, int year, int month,
			int price) {
		super(isbn, title, author, publisher, desc, price);
		this.year = year;
		this.month = month;
	}

	
	public String toString() {
		return super.toString() + " | " + year + " | " + month;
	}
}
