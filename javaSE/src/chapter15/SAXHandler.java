package chapter15;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	
	/**
	 * xml 을 parsing하기 시작할 때 한번 호출 되는 메서드
	 */
	public void startDocument() throws SAXException {
		System.out.println("---start document---");
	}
	
	/**
	 * start tag를 parsing할 때 마다 호출되는 메서드
	 * @param uri 			xmlns의 URI // XML parser에 따라 전달되지 않는 경우가 있음
	 * @param localName		tag name
	 * @param qName			prefix를 포함한 tag name // XML parser에 따라 전달되지 않는 경우가 있음
	 * @param attributes 	tag에 선언된 속성 정보
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("uri : " + uri);
		System.out.println("localName : " + localName);
		System.out.println("qName : " + qName);
		if(attributes!=null) {
			int len = attributes.getLength();
			for(int i=0;i<len;i++) {			
//				getLocalName(index) : 속성 이름 추출
//				getValue(index) : 속성 값 추출
				System.out.println(attributes.getLocalName(i) + " : " + attributes.getValue(i));
			}
		}
	}

	/**
	 * tag body의 문자 데이터를 parsing할 때 마다 호출 되는 메서드
	 * @param ch		tag body의 모든 문자들
	 * @param start		tag body의 모든 문자 중 현재 parsing하는 문자열의 시작 위치
	 * @param length	tag body의 모든 문자 중 현재 parsing하는 문자열의 길이
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("태그 바디 내용 : " + new String(ch,start,length));
	}

	
	/**
	 * end tag를 parsing 할 때마다 호출 되는 메서드
	 * @param uri 			xmlns의 URI // XML parser에 따라 전달되지 않는 경우가 있음
	 * @param localName		tag name
	 * @param qName			prefix를 포함한 tag name // XML parser에 따라 전달되지 않는 경우가 있음
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("---" + localName + " 종료---");
	}

	/**
	 * parsing이 종료 될 때 한번 호출 되는 메서드.
	 */
	public void endDocument() throws SAXException {
		System.out.println("---end document---");
	}
}
