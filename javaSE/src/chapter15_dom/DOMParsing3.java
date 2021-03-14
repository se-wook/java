package chapter15_dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParsing3 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
			Document xmldoc = parser.parse("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
			
			NodeList list = xmldoc.getElementsByTagName("location");
			for(int i=0, size = list.getLength(); i<size; i++) {
				Node node = list.item(i);
				
				for(Node child = node.getFirstChild(); child != null ; child = child.getNextSibling()) {
					if(child.getNodeType() == Node.ELEMENT_NODE) {
						if(child.getNodeName() == "data") {
							for(Node childchild = child.getFirstChild(); childchild != null ; childchild = childchild.getNextSibling()) {
								if(childchild.getNodeType() == Node.ELEMENT_NODE) {
									System.out.printf("%s:%s  ",childchild.getNodeName(),childchild.getTextContent());
								}
							}
							System.out.println();
						}else {
							System.out.printf("%s:%s\n",child.getNodeName(),child.getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
