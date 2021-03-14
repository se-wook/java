package com.ssafy.java;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductMgr pm = new ProductMgr();
		// 1. 상품 정보 add
		pm.add(new TV("2000", "Samsung-TV001", "A", 500000, 10, 75));
		pm.add(new TV("2001", "Samsung-TV002", "B", 100000, 20, 32));
		pm.add(new Refrigerator("1000","Samsung-RA101", 700000, 10, 1000));
		pm.add(new Refrigerator("1001","Samsung-RA201", 500000, 20, 3000));
		pm.add(new SmartPhone("3001","아이폰11", 700000, 1100, "APPLE","IPHONE"));
		pm.add(new SmartPhone("3002","아이폰XR", 500000, 1100, "APPLE","IPHONE"));
		pm.add(new SmartPhone("3003","아이폰XS", 400000, 1100, "APPLE","IPHONE"));
		pm.add(new SmartPhone("3004","갤럭시노트13", 990000, 2000, "SAMSUNG","GALUXY"));
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
		
		/**
		 *  6번째 과제 출력 코드
		 */
		
		// 각 제품 재고금액 리턴
		System.out.println("*************************각 제품 재고금액 검색**********************");
		System.out.println("TV : " + pm.stockMoney(new TV()) + " 원");
		System.out.println("냉장고 : " + pm.stockMoney(new Refrigerator()) + " 원");
		System.out.println("스마트폰 : " + pm.stockMoney(new SmartPhone()) + " 원");
		// 각 제품 재고 수량 리턴
		System.out.println("*************************각 제품 재고 수량 검색**********************");
		System.out.println("TV : " + pm.stockAmount(new TV()) + " 개");
		System.out.println("냉장고 : " + pm.stockAmount(new Refrigerator())+ " 개");
		System.out.println("스마트폰 : " + pm.stockAmount(new SmartPhone())+ " 개");
		
		// TV 재고의 평균인치 리턴
		System.out.println("*************************TV 재고의 평균인치 검색**********************");
		System.out.println("평균 " + pm.averageInch() + " Inch");
		
		// 냉장고의 리터 합계 리턴
		System.out.println("*************************냉장고의 리터 합계 검색**********************");
		System.out.println("총 " + pm.sumLiter() + " 리터");
		
		// 스마트폰 재고 수량 합 리턴
		System.out.println("*************************스마트폰 재고 수량 합 검색**********************");
		System.out.println(pm.sumStockAmount() + " 개");
		
		// 제품명과 가격으로 검색
		System.out.println("*************************제품명과 가격으로 검색**********************");
		Product[] p = pm.namePriceSearch("아이폰", 690000);
		for(int i=0;i<p.length;i++) {
			if(p[i] == null) break;
			System.out.println(p[i]);
		}
		
		
	}


}
