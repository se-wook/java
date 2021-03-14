package com.ssafy.workshop2;

import java.util.Arrays;

public class MovieMgr {
	private static MovieMgr manager;
	private Movie[] movies = new Movie[100];
	private int index;
	
	private MovieMgr() { }
	
	public static MovieMgr getInstance() {
		if(manager == null) {
			manager = new MovieMgr();
		}
		return manager;
	}
	
	/** 파라메터로 전달된 영화 정보를 전달받아 배열에 저장한다. */
	public void add(Movie m) {
		if(m != null) {
			String title = m.getTitle();
			int midx = -1;
			for(int i=0;i<index;i++) {
				if(title.equals(movies[i].getTitle())) {
					midx = i;
				}
			}
			if(midx == -1) {
				if(index >= movies.length) {
					Arrays.copyOf(movies, index + 100);
				}
				movies[index++] = m;
			}else {
				System.err.println("동일한 제목의 영화가 존재합니다.");
			}
		}
	}
	/** 배열에 저장된 모든 영화 정보를 리턴한다. */
	public Movie[] search() {
		return movies;
	}
	
	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 영화정보를 검색하여 리턴한다. */
	public Movie[] search(String title) {
		Movie[] m1 = new Movie[100];
		int midx = 0;
		for(int i=0;i<index;i++) {
			if(movies[i].getTitle().contains(title)) {
				m1[midx++] = movies[i];
			}
			if(midx >= m1.length) {
				Arrays.copyOf(m1, midx+100);
			}
		}
		return m1;
	}
	/** 파라메터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴한다. */
	public Movie[] searchDirector(String name) {
		Movie[] m1 = new Movie[100];
		int midx = 0;
		for(int i=0;i<index;i++) {
			if(name.equals(movies[i].getDirector())) {
				m1[midx++] = movies[i];
			}
			if(midx >= m1.length) {
				Arrays.copyOf(m1, midx+100);
			}
		}
		return m1;
	}
	/** 파라메터로 전달된 장르의 모든 영화 정보를 검색하여 리턴한다. */
	public Movie[] searchGenre(String genre) {
		Movie[] m1 = new Movie[100];
		int midx = 0;
		for(int i=0;i<index;i++) {
			if(movies[i].getGenre().equals(genre.trim())) {
				m1[midx++] = movies[i];
			}
			if(midx >= m1.length) {
				Arrays.copyOf(m1, midx+100);
			}
		}
		return m1;
	}
	/** 파라메터로 전달된 제목의 영화를 삭제한다. */
	public void delete(String title) {
		boolean flag = false;
		for(int i=0;i<index;i++) {
			if(movies[i].getTitle().equals(title)) {
				movies[i] = movies[--index];
				flag = true;
				break;
			}
		}
		if(!flag) System.out.println("해당하는 제목의 영화가 존재하지 않습니다.");
	}
	/** 저장된 영화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return index;
	}
}
