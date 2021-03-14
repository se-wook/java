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
}
