package chapter15;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAXParsing {
	static class WeatherHandler extends DefaultHandler {
		private List<Weather> list;
		private Weather weather;
		private String data;  // tag body 내용
		private String city;
		public WeatherHandler() {
			list = new LinkedList<Weather>();
		}
		public List<Weather> getWeathers(){
			return list;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)	throws SAXException {
			if(qName.equals("data")) {
				weather = new Weather();
				weather.setCity(city);
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
				weather.setDate(data);
			}else if(qName.equals("wf")) {
				if(weather != null) { //data 태그 없이 wf 나오면 weather = null.
					weather.setDesc(data);
				}
			}else if(qName.equals("tmn")) {
				weather.setTmn(data);
			}else if(qName.equals("tmx")) {
				weather.setTmx(data);
			}else if(qName.equals("reliability")) {
				weather.setReliablity(data);
			}
		}
	}
	
	public static List<Weather> getContents(String url){
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
