package chapter15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WeatherTest {
	 public static void main(String[] args) {
//		List<Weather> weat = WeatherSAXParsing.getContents("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
//		for(Weather cust : weat) {
//			System.out.println(cust);
//		}
		 
		List<HashMap<String,String>> list = WeatherSAXParsing2.getContents("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
		for(HashMap<String,String> m : list) {
			System.out.println(m);
		}
	}
}
