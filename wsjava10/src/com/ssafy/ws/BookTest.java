package com.ssafy.ws;

import java.util.List;

public class BookTest {

	public static void main(String[] args) throws QuantityException, ISBNNotFoundException {
		BookMgrImpl bm = new BookMgrImpl();
		
//		 1. 데이터 입력
//		isbn, title, price, quantity, (month)
//		bm.add(new Book("10000", "Java Pro", 15000, 15));
//		bm.add(new Book("10001", "분석 설계",30000,30));
//		bm.add(new Magazine("20000", "Java World",7000, 20, 7));
//		bm.add(new Magazine("20001", "Hello World", 17000, 17, 9));
		
		List<Book> books = bm.search();
		for(Book b : books) {
			System.out.println(b);
		}
		
		bm.send();
	}
}
