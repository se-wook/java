package chapter16;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UIExam01 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("UI 예제");
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		
		frame.add(b1, BorderLayout.CENTER);
		frame.add(b2, "North");
		frame.add(b3, "South");
		frame.add(b4, "East");
		frame.add(b5, "West");
		
		frame.setBounds(500, 500, 200, 200);
		frame.setVisible(true);
	}
}
