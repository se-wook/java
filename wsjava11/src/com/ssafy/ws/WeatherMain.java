package com.ssafy.ws;

import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherMain {
	
	private Frame frame;
	private Button Btn;
	private List li;
	private WeatherDAO wd;
	public WeatherMain() {
		wd = new WeatherDAO();
		createGUI();
		addEvent();
		showList();
	}
	 
	public void createGUI() {
		frame = new Frame("workshop");
		
		Btn = new Button("weather");
		li = new List(50);
		Panel south = new Panel();
		south.add(Btn);
		
		frame.add(li,"North");
		frame.add(south, "South");
		frame.setBounds(500,500,550,1000);
		frame.setVisible(true);
	}
	public void addEvent() {
		Btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource(); // 이벤트가 발생된 객체
				if(Btn == src) {
					wd.connectXML();
//					showList();
				}
			}
		});
	}
	public void showList() {
		
		
	}
	
	public static void main(String[] args) {
		new WeatherMain();
	}
}
