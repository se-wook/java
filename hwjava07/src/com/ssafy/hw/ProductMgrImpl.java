package com.ssafy.hw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> products;
//	private Product[] products;
	private int idx;
	
	public ProductMgrImpl() {
		products = new LinkedList<Product>();
		idx = 0;
	}
	
	//제품 번호에 해당하는 index를 리턴
	@Override
	public int findIndex(String productNo) {
		if(productNo != null) {
			for(int i=0 , idx = products.size();i<idx;i++) {
				Product product = products.get(i);
				if(productNo.equals(product.getProductNo())) {
					return i;
				}
			}
		}
		return -1;
	}
	// 모든 제품 검색
	@Override
	public List<Product> searchAll() {
		return products;
	}
	// 제품 번호에 해당하는 제품 정보 검색
	@Override
	public void search(int productNo) {
		String pNo = ""+productNo;
		int pdIdx = findIndex(pNo);
		if(pdIdx != -1){
			System.out.println(products.get(pdIdx));			
		}else{
			System.out.println("제품번호에 해당하는 정보가 없습니다.");
		}
	}
	// 제품 이름에 해당하는 제품 정보 검색
	@Override
	public void search(String productName) {
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if(product.getProductName().contains(productName)) {
				System.out.println(product);
			}
		}
	}

	@Override
	public void TVSearch() {
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof TV) {
				System.out.println(product);
			}
		}
	}
	@Override
	public void refrigeratorSearch() {
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof Refrigerator) {
				System.out.println(product);
			}
		}
	}
	@Override
	public void add(Product pd) {
		if(pd != null) {
			String productNo = pd.getProductNo();
			int pdIdx = findIndex(productNo);
			if(pdIdx != -1) {
				System.out.println("이미 해당 productNo를 갖는 상품 존재합니다.");
			}else {
				products.add(pd);
			}
		}
	}
	@Override
	public void remove(String productNo) {
		int pdIdx = findIndex(productNo);
		if(pdIdx != -1) {
//			products[pdIdx] = products[--idx];
			products.remove(pdIdx);
		}else {
			System.out.println("해당 productNo를 가진 상품이 존재하지 않습니다.");
		}
	}
	@Override
	public void allPrice() {
		int p = 0;
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if(product.getAmount() > 0) {
				System.out.println(product.getProductName() + " : " + product.getAmount()*product.getPrice() + "원");
			}
		}
	}

	@Override
	public void refrigeratorSearch400L() {
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof Refrigerator) {
				Refrigerator r = (Refrigerator) product;
				if(r.getCapacity() >= 400) {
					System.out.println(r);
				}
			}
		}		
	}

	@Override
	public void TVSearch50Inch() {
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof TV) {
				TV t = (TV) product;
				if(t.getInch() >= 50) {
					System.out.println(t);
				}
			}
		}		
	}

	@Override
	public void priceUpdate(String productNo, int price) {
		int pdIdx = findIndex(productNo);
		if(pdIdx != -1) {
			products.get(pdIdx).setPrice(price);
		}else {
			System.out.println("해당 productNo를 가진 상품이 존재하지 않습니다.");
		}
	}
	


}
