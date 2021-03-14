package com.ssafy.news;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	private List<News> newsList;
	
	public NewsDAOSAXImpl() {
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
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(url, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class SAXHandler extends DefaultHandler {
		
		private News news;
		private String data;  // tag body 내용
		private boolean flag; 
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("item")) {
				flag = true;
				news = new News();
				newsList.add(news);
			}
		}
		public void characters(char[] ch, int start, int length) throws SAXException {
			data = new String(ch, start, length);
		}
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(flag) {
				if(qName.equals("title")) {
					news.setTitle(data);
				}else if(qName.equals("link")) {
					news.setLink(data);
				}else if(qName.equals("description")) {
					news.setDesc(data);
				}
			}
		}
	}
}
