package chapter15;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import chapter05.Customer;

public class CustomerSAXParsing {
	static class CustomerHandler extends DefaultHandler {
		private List<Customer> list;
		private Customer cust;
		private String data;  // tag body 내용
		public CustomerHandler() {
			list = new LinkedList<Customer>();
		}
		public List<Customer> getCustomers(){
			return list;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)	throws SAXException {
			if(qName.equals("customer")) {
				System.out.println("?");
				cust = new Customer();
				list.add(cust);
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
//			body 내용이 어떤 tag의 내용인지 알 수 없으므로 임시 저장
			data = new String(ch, start, length);
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("name")) {
				cust.setName(data);
			}else if(qName.equals("address")) {
				cust.setAddress(data);
			}else if(qName.equals("age")) {
				try {
					cust.setAge(Integer.parseInt(data.trim()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static List<Customer> getContents(String url){
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			CustomerHandler handler = new CustomerHandler();
			parser.parse(url, handler);
			return handler.getCustomers();
		} catch (Exception e) { // checkedexception
			e.printStackTrace();
			return null;
		}
	}
	
}
