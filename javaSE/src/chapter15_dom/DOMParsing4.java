package chapter15_dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParsing4 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
			Document xmldoc = parser.parse("res/customerlist.xml");
			
			Element newNode = xmldoc.createElement("customer");
			Element name = xmldoc.createElement("name");
			name.appendChild(xmldoc.createTextNode("길동홍"));
			Element age = xmldoc.createElement("age");
			age.appendChild(xmldoc.createTextNode("20"));
			Element address = xmldoc.createElement("address");
			address.appendChild(xmldoc.createTextNode("나몰라"));
			newNode.appendChild(name);
			newNode.appendChild(age);
			newNode.appendChild(address);
			
			
			
			
			
			Element root = xmldoc.getDocumentElement(); // customerlist tag 추출
			root.appendChild(newNode);
			
			// customer 태그를 추출
			for(Node node = root.getFirstChild(); node != null; node = node.getNextSibling()) {
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					for(Node child = node.getFirstChild(); child != null ; child = child.getNextSibling()) {
						if(child.getNodeType() == Node.ELEMENT_NODE) {
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
