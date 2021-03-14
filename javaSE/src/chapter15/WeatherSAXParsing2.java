package chapter15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAXParsing2 {
	static class WeatherHandler extends DefaultHandler {
		private List<HashMap<String,String>> list;
		private HashMap<String,String> weather;
		private String data;  // tag body 내용
		private String city;
		public WeatherHandler() {
			list = new LinkedList<>();
		}
		public List<HashMap<String,String>> getWeathers(){
			return list;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)	throws SAXException {
			if(qName.equals("data")) {
				weather = new HashMap<String,String>();
				weather.put("city",city);
				list.add(weather);
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
//			body 내용이 어떤 tag의 내용인지 알 수 없으므로 임시 저장
			data = new String(ch, start, length);
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("city")) {
				city = data;
			}else if(qName.equals("tmEf")) {
				weather.put(qName,data);
			}else if(qName.equals("wf")) {
				if(weather != null) { //data 태그 없이 wf 나오면 weather = null.
					weather.put(qName,data);
				}
			}else if(qName.equals("tmn")) {
				weather.put(qName,data);
			}else if(qName.equals("tmx")) {
				weather.put(qName,data);
			}else if(qName.equals("reliability")) {
				weather.put(qName,data);
			}
		}
	}
	
	public static List<HashMap<String,String>> getContents(String url){
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			WeatherHandler handler = new WeatherHandler();
			parser.parse(url, handler);
			return handler.getWeathers();
		} catch (Exception e) { // checkedexception
			e.printStackTrace();
			return null;
		}
	}
	
}
