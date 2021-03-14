package com.ssafy.ws;

public class Weather {
	private int hour;
	private double temp;
	private String wfKor;
	private int rel;
	public Weather() {	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public int getRel() {
		return rel;
	}
	public void setRel(int rel) {
		this.rel = rel;
	}
	public String toString() {
		return "hour : " + hour + " temp : " + temp + " wfKor : " + wfKor + " rel : " + rel;
	}
}
