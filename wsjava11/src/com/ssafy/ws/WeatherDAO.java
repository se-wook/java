package com.ssafy.ws;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
	private List<Weather> list;
	private static WeatherDAO wd;
	
	public WeatherDAO() {}
	
	public WeatherDAO getInstance() {
		if(wd == null) {
			wd = new WeatherDAO();
		}
		return wd;
	}
	
	public List<Weather> getWeatherList(){
		return list;
	}
	
	public void connectXML() {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
			Document xmldoc = parser.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
			
			NodeList list = xmldoc.getElementsByTagName("body");
			for(int i=0, size = list.getLength(); i<size; i++) {
				Node node = list.item(i);
				for(Node childs = node.getFirstChild(); childs != null ; childs = childs.getNextSibling()) {
					if(childs.getNodeType() == Node.ELEMENT_NODE) {
						if(childs.getNodeName() == "data") {
							for(Node child = childs.getFirstChild(); child != null ; child = child.getNextSibling()) {
								if(child.getNodeType() == Node.ELEMENT_NODE) {
									System.out.printf("%s:%s  ",child.getNodeName(),child.getTextContent());
								}
							}
							System.out.println();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
