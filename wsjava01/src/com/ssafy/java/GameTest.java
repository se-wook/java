package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static int winner(int h, int c) {
		if(h == 1 || h ==2) {
			if(h > c) {
				System.out.println("�̰���ϴ�!!!");
				return 1;
			}else {
				System.out.println("�����ϴ�!!!");
				return 0;
			}
		}else{
			if(c == 1) {
				System.out.println("�����ϴ�!!!");
				return 0;
			}else {
				System.out.println("�̰���ϴ�!!!");
				return 1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">> ���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		
		int game = sc.nextInt();
		int computer = 0, human = 0;

		switch(game){
			case 1: // 3��
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("��ȣ�� �Է��ϼ���: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("�����ϴ�!!!");
					}else {
						int res = winner(in,com);
						if (res == 1) {
							human++;
						}else {
							computer++;
						}
					}
					if(human == 3) {
						System.out.println("### ��� ��!");
						break;
					}else if(computer == 3) {
						System.out.println("### ��ǻ�� ��!");
						break;
					}
				}
				break;
			case 2: // 2��
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("��ȣ�� �Է��ϼ���: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("�����ϴ�!!!");
					}else {
						int res = winner(in,com);
						if (res == 1) {
							human++;
						}else {
							computer++;
						}
					}
					if(human == 2) {
						System.out.println("### ��� ��!");
						break;
					}else if(computer == 2) {
						System.out.println("### ��ǻ�� ��!");
						break;
					}
				}
				break;
			case 3: // 1��
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("��ȣ�� �Է��ϼ���: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("�����ϴ�!!!");
					}else {
						int res = winner(in,com);
						if(res == 1) {
							System.out.println("### ��� ��!!!");
							break;
						}else if(res == 0) {
							System.out.println("### ��ǻ�� ��!!!");
							break;
						}
					}
				}
				break;
				default:
					System.out.println("��⸦ �߸� �����߽��ϴ�. \n������ �ٽ� �������ּ���.");
		}
	}

}
