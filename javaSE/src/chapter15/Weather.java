package chapter15;

import java.io.Serializable;

public class Weather implements Serializable{
	private String city, date, desc, tmn, tmx, reliablity;

	public Weather() {}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTmn() {
		return tmn;
	}

	public void setTmn(String tmn) {
		this.tmn = tmn;
	}

	public String getTmx() {
		return tmx;
	}

	public void setTmx(String tmx) {
		this.tmx = tmx;
	}

	public String getReliablity() {
		return reliablity;
	}

	public void setReliablity(String reliablity) {
		this.reliablity = reliablity;
	}
	@Override
	public String toString() {
		return "city : " + city + "date : " + date + "desc : " + desc + "tmn : " +tmn + "tmx : " + tmx + "reliablity : " + reliablity;
	}
}
