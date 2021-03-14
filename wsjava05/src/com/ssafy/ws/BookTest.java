package com.ssafy.ws;

public class BookTest {

	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		// 1. 데이터 입력
		bm.add(new Book("10000", "Java Pro", "김하나", "Jaen.kr", "Java 기본 문법", 15000));
		bm.add(new Book("10001", "분석 설계", "소나무", "Jaen.kr", "SW 모델링", 30000));
		bm.add(new Magazine("20000", "Java World", "편집부", "java.com", "첫걸음", 2018, 02, 7000));
		bm.add(new Magazine("20001", "Hello World", "SSAFY", "java.com", "안녕하세요", 2017, 03, 17000));
		
		// 2. 전체 검색
		System.out.println("======================전체 검색=========================");
		bm.showAll();
		
		// 3. isbn으로 정보 검색
		System.out.println("======================isbn 검색=========================");
		bm.isbnSearch("10001");
		
		// 4. title로 정보 검색 (부분 문자열 포함)
		System.out.println("======================title 검색=========================");
		bm.titleSearch("Java");
		
		// 5. Book 만 검색
		System.out.println("======================book 검색=========================");
		bm.bookSearch();
		
		// 6. Magazine 만 검색
		System.out.println("======================Magazine 검색=========================");
		bm.magazineSearch();
		
		// 7. publisher 검색
		System.out.println("======================publisher 검색=========================");
		bm.publisherSearch("java.com");
		
		// 8. 가격 검색
		System.out.println("======================가격 검색=========================");
		bm.priceSearch(30000);

		// 9. sum
		System.out.println("======================sum=========================");
		System.out.println(bm.sum());
		
		// 10. average
		System.out.println("======================average=========================");
		System.out.println(bm.average());
		
	}
}
