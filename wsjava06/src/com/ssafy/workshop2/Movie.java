package com.ssafy.workshop2;

public class Movie {
	private String title, director, genre, summary;
	private int grade;
	
	public Movie() {}
	
	public Movie(String title, String director, String genre, String summary, int grade) {
		setTitle(title);
		setDirector(director);
		setGenre(genre);
		setSummary(summary);
		setGrade(grade);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String toString() {
		return title + " | " + director + " | " + grade + " | " + genre + " | " + summary ;
	}
}
