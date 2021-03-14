package com.ssafy.news;

import java.util.List;


public class NewsTest {

	public static void main(String[] args) {
		NewsDAOSAXImpl nn = new NewsDAOSAXImpl();
		List<News> custs = nn.getNewsList("http://rss.etnews.com/Section902.xml");
		for(News cust : custs) {
			System.out.println(cust);
		}
	}

}
