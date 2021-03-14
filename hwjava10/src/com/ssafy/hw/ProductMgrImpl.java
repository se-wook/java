package com.ssafy.hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ProductMgrImpl implements IProductMgr {
	private List<Product> products;
	private int idx;
	private String fileName = "product.dat";
	
	public ProductMgrImpl() {
		products = new ArrayList<Product>();
		open();
	}
	
	public void send() {
		List<Product> tvtv = new ArrayList<>();
		List<Product> refri = new ArrayList<>();
		
		for(int i=0;i<products.size();i++) {
			if(products.get(i) instanceof TV) {
				TV tv = (TV) products.get(i);
				tvtv.add(tv);
			}else {
				Refrigerator rf = (Refrigerator) products.get(i);
				refri.add(rf);
			}
		}
		
		new Thread() {
			public void run() {
				Socket s = null;
				ObjectOutputStream oos = null;
				try {
					s = new Socket("127.0.0.1", 8975);
					oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(tvtv);
					oos.writeObject(refri);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(oos);
					IOUtil.close(s);
				}
			}
		}.start();
	}	
	public void open() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				products = (List) ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {try {ois.close();}catch(Exception e) {}}
			if(fis != null) {try {fis.close();}catch(Exception e) {}}
		}
	}
	
	public void save() {
		new Thread() {
			@Override
			public void run() {
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
				try {
					fos = new FileOutputStream(fileName);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(products);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(oos);
					IOUtil.close(fos);
				}
			}
		}.start();
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
	public void search(int productNo) throws CodeNotFoundException {
		String pNo = ""+productNo;
		int pdIdx = findIndex(pNo);
		if(pdIdx != -1){
			System.out.println(products.get(pdIdx));			
		}else{
			throw new CodeNotFoundException();
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
	public void add(Product pd) throws DuplicateException {
		if(pd != null) {
			String productNo = pd.getProductNo();
			int pdIdx = findIndex(productNo);
			if(pdIdx != -1) {
				throw new DuplicateException();
			}else {
				products.add(pd);
			}
		}
	}
	@Override
	public void remove(String productNo) {
		int pdIdx = findIndex(productNo);
		if(pdIdx != -1) {
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
	public void refrigeratorSearch400L() throws ProductNotFoundException {
		boolean flag = false;
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof Refrigerator) {
				Refrigerator r = (Refrigerator) product;
				if(r.getCapacity() >= 400) {
					flag = true;
					System.out.println(r);
				}
			}
		}
		if(!flag) throw new ProductNotFoundException();
	}

	@Override
	public void TVSearch50Inch() throws ProductNotFoundException {
		boolean flag = false;
		for(int i=0 , idx = products.size();i<idx;i++) {
			Product product = products.get(i);
			if (product instanceof TV) {
				TV t = (TV) product;
				if(t.getInch() >= 50) {
					flag = true;
					System.out.println(t);
				}
			}
		}
		if(!flag) throw new ProductNotFoundException();
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
	
	public void close() {
		save();
		System.exit(0);
	}


}
