package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static int winner(int h, int c) {
		if(h == 1 || h ==2) {
			if(h > c) {
				System.out.println("이겼습니다!!!");
				return 1;
			}else {
				System.out.println("졌습니다!!!");
				return 0;
			}
		}else{
			if(c == 1) {
				System.out.println("졌습니다!!!");
				return 0;
			}else {
				System.out.println("이겼습니다!!!");
				return 1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">> 가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		
		int game = sc.nextInt();
		int computer = 0, human = 0;

		switch(game){
			case 1: // 3승
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("번호를 입력하세요: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("번호를 잘못 입력했습니다.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("비겼습니다!!!");
					}else {
						int res = winner(in,com);
						if (res == 1) {
							human++;
						}else {
							computer++;
						}
					}
					if(human == 3) {
						System.out.println("### 사람 승!");
						break;
					}else if(computer == 3) {
						System.out.println("### 컴퓨터 승!");
						break;
					}
				}
				break;
			case 2: // 2승
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("번호를 입력하세요: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("번호를 잘못 입력했습니다.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("비겼습니다!!!");
					}else {
						int res = winner(in,com);
						if (res == 1) {
							human++;
						}else {
							computer++;
						}
					}
					if(human == 2) {
						System.out.println("### 사람 승!");
						break;
					}else if(computer == 2) {
						System.out.println("### 컴퓨터 승!");
						break;
					}
				}
				break;
			case 3: // 1승
				computer = 0;
				human = 0;
				while(true) {
					System.out.print("번호를 입력하세요: ");
					int in = sc.nextInt();
					if(in > 3 || in < 1) {
						System.out.println("번호를 잘못 입력했습니다.");
						continue;
					}
					int com = (int)(Math.random()*3)+1;
					if(in == com) {
						System.out.println("비겼습니다!!!");
					}else {
						int res = winner(in,com);
						if(res == 1) {
							System.out.println("### 사람 승!!!");
							break;
						}else if(res == 0) {
							System.out.println("### 컴퓨터 승!!!");
							break;
						}
					}
				}
				break;
				default:
					System.out.println("경기를 잘못 선택했습니다. \n게임을 다시 시작해주세요.");
		}
	}

}
