package com.ssafy.hw;

import java.util.List;

public class ProductTest {

	public static void main(String[] args)  {
		
		ProductMgrImpl pm = new ProductMgrImpl();
		// 1. 상품 정보 add
		try {
			pm.add(new TV("2000", "Samsung-TV001", "A", 500000, 10, 72));
			pm.add(new TV("2001", "Samsung-TV002", "B", 100000, 20, 32));
			pm.add(new Refrigerator("1000","Samsung-RA101", 700000, 10, 1000));
			pm.add(new Refrigerator("1001","Samsung-RA201", 500000, 20, 3000));
		} catch (DuplicateException e) {
			e.printStackTrace();
		}

		// 2. 상품 전체 검색
		System.out.println("*************************상품 전체 검색**************************");
		pm.searchAll();
		List<Product> products = pm.searchAll();
		for(Product p : products) {
			System.out.println(p);
		}
		// 3. 상품 번호로 검색
		System.out.println("=====================상품 번호로 검색=====================");
		try {
			pm.search(Integer.parseInt("2001"));
		} catch (NumberFormatException | CodeNotFoundException e) {
			e.printStackTrace();
		}
		// 4. 상품 명으로 검색 (부분 검색)
		System.out.println("*************************상품명 검색****************************");
		pm.search("TV");
		// 5. TV 정보만 검색
		System.out.println("*************************TV 정보만 검색**************************");
		pm.TVSearch();
		// 6. Refrigerator 정보만 검색
		System.out.println("*************************Refrigerator 정보만 검색****************");
		pm.refrigeratorSearch();
		// 7. 상품 번호로 상품 삭제
		System.out.println("*************************상품 번호로 상품 삭제**********************");
		pm.remove("2001");
		products = pm.searchAll();
		for(Product p : products) {
			System.out.println(p);
		}		
		// 8. 400L 이상의 냉장고 검색
		System.out.println("=====================*400L 이상의 냉장고 검색*=====================");
		try {
			pm.refrigeratorSearch400L();
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 9. 50inch 이상의 TV 검색
		System.out.println("=====================*50inch 이상의 TV 검색*=====================");
		try {
			pm.TVSearch50Inch();
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 10. 상품번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
		System.out.println("************상품번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능**************");
		pm.priceUpdate("1000", 400000);
		products = pm.searchAll();
		for(Product p : products) {
			System.out.println(p);
		}		
		// 11. 전체 재고 상품 금액 검색
		System.out.println("***********************전체 재고 상품 금액 검색**********************");
		pm.allPrice();
		
		pm.close();
	}


}
