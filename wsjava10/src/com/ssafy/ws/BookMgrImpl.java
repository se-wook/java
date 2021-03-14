package com.ssafy.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class BookMgrImpl implements IBookMgr{

	
	private List<Book> books;
	private String fileName = "book.dat";
	private int idx;
	public BookMgrImpl() {
		books = new LinkedList<Book>();
		open();
	}
	
	class BookClient extends Thread {
		private List<Book> list;
		
		public BookClient() {
			list = books;
		}

		@Override
		public void run() {
			Socket s = null;
			ObjectOutputStream oos = null;
			try {
				s = new Socket("127.0.0.1", 8981);
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(list);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				IOUtil.close(oos);
				IOUtil.close(s);
			}
		}
	}
	public void send() {
		BookClient bc = new BookClient();
		bc.start();
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
				books = (List) ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {try {ois.close();}catch(Exception e) {}}
			if(fis != null) {try {fis.close();}catch(Exception e) {}}
		}
	}
	
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {try {oos.close();}catch(Exception e) {}} // 작은문 닫고
			if(fos != null) {try {fos.close();}catch(Exception e) {}} // 큰문 닫기
		}
	}
	
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		int bookidx = findIndex(isbn);
		if(bookidx != -1) {
			int qu = books.get(bookidx).getQuantity();
			if(qu >= quantity) {
				books.get(bookidx).setQuantity(qu-quantity);
			}else {
				throw new QuantityException();
			}
		}else {
			throw new ISBNNotFoundException();
		}		
	}
	
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		int bookidx = findIndex(isbn);
		if(bookidx != -1) {
			int qu = books.get(bookidx).getQuantity();
			books.get(bookidx).setQuantity(qu+quantity);
		}else {
			throw new ISBNNotFoundException();
		}
	}
	public int getTotalAmount() {
		int res = 0;
		for(int i=0;i<books.size();i++) {
			int q = books.get(i).getQuantity();
			int p = books.get(i).getPrice();
			res += q*p;
		}
		return res;
	}
	
	
	@Override
	public int findIndex(String isbn) {
		if(isbn != null) {
			for(int i=0, idx=books.size();i<idx;i++) {
				Book book = books.get(i);
				if(isbn.equals(book.getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}

	// 1. 입력 기능
	@Override
	public void add(Book book) {
		if(book != null) {
			String isbn = book.getIsbn();
			int bookidx = findIndex(isbn);
			if(bookidx != -1) {
				System.out.println("이미 등록된 isbn입니다.");
			}else {
				books.add(book);
			}
		}
	}

	
	// 2. 전체 검색 기능
	@Override
	public List<Book> search() {
		return books;	
	}
	
	// 닫기
	public void close() {
		save(); 
		System.exit(0); // JVM 종료
	}

}
