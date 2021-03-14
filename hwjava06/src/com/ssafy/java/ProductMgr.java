package com.ssafy.java;

import java.util.Arrays;

public class ProductMgr {
	private Product[] products;
	private int idx;
	
	public ProductMgr() {
		products = new Product[10];
		idx = 0;
	}
	
	//제품 번호에 해당하는 index를 리턴
	public int findIndex(String productNo) {
		if(productNo != null) {
			for(int i=0;i<idx;i++) {
				if(productNo.equals(products[i].getProductNo())) {
					return i;
				}
			}
		}
		return -1;
	}
	// 모든 제품 검색
	public void search() {
		for(int i=0;i<idx;i++) {
			System.out.println(products[i]);
		}
	}
	// 제품 번호에 해당하는 제품 정보 검색
	public void search(int productNo) {
		String pNo = ""+productNo;
		int pdIdx = findIndex(pNo);
		if(pdIdx != -1){
			System.out.println(products[pdIdx]);			
		}else{
			System.out.println("제품번호에 해당하는 정보가 없습니다.");
		}
	}
	// 제품 이름에 해당하는 제품 정보 검색
	public void search(String productName) {
		for(int i=0;i<idx;i++) {
			if(products[i].getProductName().contains(productName)) {
				System.out.println(products[i]);
			}
		}
	}

	public void TVSearch() {
		for(int i=0;i<idx;i++) {
			if (products[i] instanceof TV) {
				System.out.println(products[i]);
			}
		}
	}
	public void refrigeratorSearch() {
		for(int i=0;i<idx;i++) {
			if (products[i] instanceof Refrigerator) {
				System.out.println(products[i]);
			}
		}
	}
	public void add(Product pd) {
		if(pd != null) {
			String productNo = pd.getProductNo();
			int pdIdx = findIndex(productNo);
			if(pdIdx != -1) {
				System.out.println("이미 해당 productNo를 갖는 상품 존재합니다.");
			}else {
				if(idx >= products.length) {
					products = Arrays.copyOf(products, idx+5);
				}
				products[idx++] = pd;
			}
		}
	}
	public void remove(String productNo) {
		int pdIdx = findIndex(productNo);
		if(pdIdx != -1) {
			products[pdIdx] = products[--idx]; 
		}else {
			System.out.println("해당 productNo를 가진 상품이 존재하지 않습니다.");
		}
	}
	public void allPrice() {
		int p = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getAmount() > 0) {
				System.out.println(products[i].getProductName() + " : " + products[i].getAmount()*products[i].getPrice() + "원");
			}
		}
	}
	
	/** 6번째 과제에 추가된 메서드*/
	
	/** 1. 파라메터로 TV인지 냉장고 또는 스마트폰인지를 전달받아 각 제품의 재고금액을 리턴하는 기능*/
	public int stockMoney(Product p) {
		int res = 0;
		int amount = 0, price = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getClass() == p.getClass()) {
				amount = products[i].getAmount();
				price = products[i].getPrice();
				res += (amount*price);
			}
		}
		return res;
	}
	
	/** 2. 파라메터로 TV인지 냉장고 또는 스마트폰인지를 전달받아 각 제품의 재고 수량을 리턴하는 기능 */
	public int stockAmount(Product p) {
		int amount = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getClass() == p.getClass()) {
				amount += products[i].getAmount();
			}
		}
		return amount;
	}
	
	/** 3. TV 재고의 평균 인치를 리턴하는 기능*/
	public int averageInch() {
		int inch = 0;
		for(int i=0;i<idx;i++) {
			if (products[i] instanceof TV) {
				TV p = (TV) products[i];
				inch += p.getInch();
			}
		}
		return inch;
	}
	
	/** 4. 냉장고의 리터합계를 리턴하는 기능 */
	public int sumLiter() {
		int liter = 0;
		for(int i=0;i<idx;i++) {
			if (products[i] instanceof Refrigerator) {
				Refrigerator p = (Refrigerator) products[i];
				liter += p.getCapacity();
			}
		}
		return liter;
	}
	
	/** 5. 스마트폰의 재고 수량의 합을 리턴하는 기능 */
	public int sumStockAmount() {
		int amount = 0;
		for(int i=0;i<idx;i++) {
			if (products[i] instanceof SmartPhone) {
				SmartPhone p = (SmartPhone) products[i];
				amount += p.getAmount();
			}
		}
		return amount;
	}
	
	/** 6. 파라메터로 상품명(부분문자열 가능)과 금액을 전달하면 전달된 상품명을
	 * 포함하는 상품 중에서 파라메터로 전달된 금액보다 작은 금액의 상품들의 정보를 리턴하는 기능*/
	public Product[] namePriceSearch(String name, int price) {
		Product[] pd = new Product[100];
		int pidx = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getProductName().contains(name)) {
				if(products[i].getPrice() < price) {
					pd[pidx++] = products[i];
					if(pidx >= pd.length) {
						Arrays.copyOf(pd, pidx+100);
					}
				}
			}
		}
		return pd;
	}
}
