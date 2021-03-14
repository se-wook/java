package com.ssafy.BookTest;

import com.ssafy.Book.Book;
import com.ssafy.Magazine.Magazine;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("21424","Java Pro","김하나","Jaen.kr","Java 기본 문법",15000);
		Book b2 = new Book("35355","분석 설계","소나무","Jaen.kr","SW 모델링",30000);
		Magazine m = new Magazine("35535","Java World","편집부","java.com","첫걸음",2018,02,7000);
		System.out.println("************************도서 목록*************************");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(m.toString());
	}

	
}

