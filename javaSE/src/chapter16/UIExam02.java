package chapter16;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UIExam02 extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextArea view = new JTextArea();
	private JButton sendB = new JButton("전송");
	private JButton exitB = new JButton("종료");
	
//	class EventHandler implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	
//	private ActionListener handler = new EventHandler();
//	
	
	/**
	 * ActionListener 버튼이 클릭 되거나 엔터키 이벤트를 처리해주는 인터페이스
	 */
	private ActionListener handler = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 이벤트가 발생된 객체
			if(src == sendB || src == input) {
				String msg = input.getText();
				view.append(msg);
				view.append("\n");
				input.setText("");
			}else if(src == exitB) {
				System.exit(0);
			}
		}
	};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIExam02 frame = new UIExam02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIExam02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(5, 1, 5, 5));
		
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(sendB);
		
		panel.add(exitB);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(view);
		
		input = new JTextField();
		contentPane.add(input, BorderLayout.SOUTH);
		input.setColumns(10);
		
		//이벤트 연결
		sendB.addActionListener(handler);
		exitB.addActionListener(handler);
		input.addActionListener(handler);
	}

}
