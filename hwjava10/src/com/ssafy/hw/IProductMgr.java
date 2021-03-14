package com.ssafy.hw;

import java.util.List;

public interface IProductMgr {
	
	/** 기존 과제 내용 */
	//제품 번호에 해당하는 index를 리턴
	int findIndex(String productNo);
	// 2. 상품 정보 전체를 검색
	List<Product> searchAll();
	// 4. 상품명으로 상품을 검색
	void search(String productName);
	// 5. TV만 검색
	void TVSearch();
	// 6. 냉장고만 검색
	void refrigeratorSearch();
	// 9. 상품번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
	void priceUpdate(String productNo, int price);
	// 10. 상품 번호로 상품 삭제
	void remove(String productNo);
	// 11. 전체 재고 상품 금액을 구하는 기능
	void allPrice();

	/** 08 과제 추가 */
	void open();
	void save();
	void close();
	// 1. 상품 정보를 저장.
	void add(Product pd) throws DuplicateException;
	// 3. 상품 번호로 상품을 검색
	void search(int productNo) throws CodeNotFoundException;
	// 7. 400L 이상의 냉장고 검색
	void refrigeratorSearch400L() throws ProductNotFoundException;
	// 8. 50inch 이상의 TV 검색
	void TVSearch50Inch() throws ProductNotFoundException;
}