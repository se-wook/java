package com.ssafy.hw;

import java.util.List;

public interface IProductMgr {

	//제품 번호에 해당하는 index를 리턴
	int findIndex(String productNo);
	// 1. 상품 정보를 저장.
	void add(Product pd);
	// 2. 상품 정보 전체를 검색
	List<Product> searchAll();
	// 3. 상품 번호로 상품을 검색
	void search(int productNo);
	// 4. 상품명으로 상품을 검색
	void search(String productName);
	// 5. TV만 검색
	void TVSearch();
	// 6. 냉장고만 검색
	void refrigeratorSearch();
	// 7. 400L 이상의 냉장고 검색
	void refrigeratorSearch400L();
	// 8. 50inch 이상의 TV 검색
	void TVSearch50Inch();
	// 9. 상품번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
	void priceUpdate(String productNo, int price);
	// 10. 상품 번호로 상품 삭제
	void remove(String productNo);
	// 11. 전체 재고 상품 금액을 구하는 기능
	void allPrice();

}