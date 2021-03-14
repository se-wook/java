package com.ssafy.ws;

import java.util.LinkedList;
import java.util.List;

public class BookMgrImpl implements IBookMgr{

	
	private List<Book> books;
	private int idx;
	public BookMgrImpl() {
		books = new LinkedList<Book>();
		idx = 0;
	}
	@Override
	public int findIndex(String isbn) {
		if(isbn != null) {
			for(int i=0, idx=books.size();i<idx;i++) {
				Book book = books.get(i);
				if(isbn.equals(book.getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}

	
	// 1. 입력 기능
	@Override
	public void add(Book book) {
		if(book != null) {
			String isbn = book.getIsbn();
			int bookidx = findIndex(isbn);
			if(bookidx != -1) {
				System.out.println("이미 등록된 isbn입니다.");
			}else {
				books.add(book);
			}
		}
	}

	
	// 2. 전체 검색 기능
	@Override
	public List<Book> searchAll() {
		return books;	
	}

	
	// 3. isbn 검색 기능
	@Override
	public void isbnSearch(String isbn) {
		int bookidx = findIndex(isbn);
		if(bookidx != -1) {
			System.out.println(books.get(bookidx));
		}else {
			System.out.println("검색 결과가 없습니다.");
		}		
	}

	// 4. title 검색 기능
	@Override
	public void titleSearch(String title) {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if(book.getTitle().contains(title)) {
				System.out.println(book);
			}
		}		
	}

	// 5. book 검색 기능
	@Override
	public void bookSearch() {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if (!(book instanceof Magazine)) {
				System.out.println(book);					
			}
		}		
	}

	// 6. magazine 검색 기능
	@Override
	public void magazineSearch() {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if (book instanceof Magazine) {
				System.out.println(book);
			}
		}		
	}

	//7. 올해의 magazine 검색 기능
	@Override
	public void magazineSearch(int year) {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if (book instanceof Magazine) {
				Magazine m = (Magazine) book;
				if(year == m.getYear()) {
					System.out.println(book);
				}
			}
		}		
	}
	// 8. 출판사 검색 기능
	@Override
	public void publisherSearch(String publisher) {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if(publisher.equals(book.getPublisher())) {
				System.out.println(book);
			}
		}		
	}

	
	// 9. 가격 검색 기능
	@Override
	public void priceSearch(int price) {
		for(int i=0,idx=books.size();i<idx;i++) {
			Book book = books.get(i);
			if(book.getPrice() < price) {
				System.out.println(book);
			}
		}		
	}

	// 10. 금액 합계
	@Override
	public int sum() {
		int p = 0;
		for(int i=0,idx=books.size();i<idx;i++) {
			p += books.get(i).getPrice();
		}
		return p;
	}

	// 11. 평균 금액
	@Override
	public int average() {
		int p = sum();
		int m = books.size();
		return p/m;
	}

}
