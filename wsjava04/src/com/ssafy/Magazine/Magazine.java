package com.ssafy.Magazine;

public class Magazine {
	private String isbn, title, author, publisher, desc;
	private int year, month, price;
	public Magazine() {	}
	
	public Magazine(String isbn, String title, String author, String publisher, String desc, int year, int month,
			int price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.year = year;
		this.month = month;
		this.price = price;
	}

	public String toString() {
		return isbn + " | " + String.format("%-10s", title) + " | " + author + " | " + publisher + " | "
				+price + " | "+ desc + " | " + year + "." + month;
	}
}
