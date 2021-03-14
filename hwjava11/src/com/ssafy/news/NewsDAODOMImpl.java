package com.ssafy.news;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	private List<News> newsList;

	public NewsDAODOMImpl() {
		newsList = new LinkedList<>();
	}
	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return newsList;
	}

	@Override
	public News search(int index) {
		return newsList.get(index);
	}

	private void connectNews(String url) {
		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fac.newDocumentBuilder();
			Document xmldoc = parser.parse(url);

			NodeList list = xmldoc.getElementsByTagName("item");
			for (int i = 0, size = list.getLength(); i < size; i++) {
				Node node = list.item(i);
				News n = new News();
				for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child.getNodeType() == Node.ELEMENT_NODE) {
						if (child.getNodeName().equals("title")) {
							n.setTitle(child.getTextContent());
						} else if (child.getNodeName().equals("link")) {
							n.setLink(child.getTextContent());
						} else if (child.getNodeName().equals("description")) {
							n.setDesc(child.getTextContent());
						}
					}
				}
				newsList.add(n);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
