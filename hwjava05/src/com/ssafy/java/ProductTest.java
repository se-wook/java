package com.ssafy.java;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductMgr pm = new ProductMgr();
		// 1. 상품 정보 add
		pm.add(new TV("2000", "Samsung-TV001", "A", 500000, 10, 75));
		pm.add(new TV("2001", "Samsung-TV002", "B", 100000, 20, 32));
		pm.add(new Refrigerator("1000","Samsung-RA101", 700000, 10, 1000));
		pm.add(new Refrigerator("1001","Samsung-RA201", 500000, 20, 3000));
		// 2. 상품 전체 검색
		System.out.println("*************************상품 전체 검색**************************");
		pm.search();
		// 3. 상품 번호로 검색
		System.out.println("*************************상품 번호로 검색*************************");
		pm.search(Integer.parseInt("2001"));
		// 4. 상품 명으로 검색 (부분 검색)
		System.out.println("*************************상품명 검색****************************");
		pm.search("Samsung");
		// 5. TV 정보만 검색
		System.out.println("*************************TV 정보만 검색**************************");
		pm.TVSearch();
		// 6. Refrigerator 정보만 검색
		System.out.println("*************************Refrigerator 정보만 검색****************");
		pm.refrigeratorSearch();
		// 7. 상품 번호로 상품 삭제
		System.out.println("*************************상품 번호로 상품 삭제**********************");
		pm.remove("2001");
		pm.search();
		// 8. 전체 재고 상품 금액 검색
		System.out.println("*************************전체 재고 상품 금액 검색**********************");
		pm.allPrice();
//		
	}

}
