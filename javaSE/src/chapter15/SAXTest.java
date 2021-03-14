package chapter15;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXTest {
	public static void main(String[] args) {

//		ClassLoader 추출하기
//		SAXTest t = new SAXTest();
//		t.getClass().getClassLoader(); // 클래스 로드한 객체
		
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109", handler);
		} catch (Exception e) { // checkedexception
			e.printStackTrace();
		}
	}
}
