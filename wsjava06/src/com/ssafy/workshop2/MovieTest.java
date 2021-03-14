package com.ssafy.workshop2;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieMgr mm = MovieMgr.getInstance();
		
		mm.add(new Movie("아이언맨","로버트 다우니 주니어","SF","안녕하세요",1));
		mm.add(new Movie("아이언맨2","로버트 다우니 주니어","SF","감사합니다",2));
		mm.add(new Movie("아이언맨3","로버트 다우니 주니어","SF","재밌어요",3));
		mm.add(new Movie("스파이더맨","거미남자","액션","쿨쿨",4));
		mm.add(new Movie("스파이더맨3: 파 프롬 홈","거미남자","액션","재밌습니다",5));
		program: 
		while (true) {
			System.out.printf("<<영화 관리 프로그램>> \n 1. 영화 정보 입력 \n 2. 영화 정보 전체 검색 \n"
					+ " 3. 영화명 검색 \n 4. 영화 장르별 검색 \n 5. 영화 정보 삭제 \n 0. 종료 \n원하는 번호를 선택하세요.");
			int n = sc.nextInt();
			sc.nextLine();

			String title, direc, genre, sumry;
			int grade;
			switch (n) {
			case 1:
				System.out.println("영화 정보 입력");
				System.out.println("영화 정보를 입력해 주세요.");
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("감독 : ");
				direc = sc.nextLine();
				System.out.print("장르 : ");
				genre = sc.nextLine();
				System.out.print("요약 : ");
				sumry = sc.nextLine();
				System.out.print("등급 : ");
				grade = sc.nextInt();
				sc.nextLine();

				Movie m1 = new Movie(title, direc, genre, sumry, grade);
				mm.add(m1);
				break;
			case 2:
				System.out.println("영화 정보 전체 검색입니다.");
				Movie[] mv = mm.search();
				int x = mm.getSize();
				for(int i=0;i<x;i++) {
					System.out.println(mv[i]);
				}
				break;
			case 3:
				System.out.print("영화명 검색 \n 영화명을 입력해주세요. \n영화명 : ");
				title = sc.nextLine();
				mv = mm.search(title);
				for(int i=0;i<mv.length;i++) {
					if(mv[i] == null) break;
					System.out.println(mv[i]);
				}
				break;
			case 4:
				System.out.print("영화 장르 검색 \n 영화 장르를 검색해주세요. \n장르 : ");
				genre = sc.nextLine();
				mv = mm.searchGenre(genre);
				for(int i=0;i<mv.length;i++) {
					if(mv[i] == null) break;
					System.out.println(mv[i]);
				}
				break;
			case 5:
				System.out.print("영화 정보 삭제 입니다. \n삭제할 영화 제목을 입력해주세요. \n영화명 : ");
				title = sc.nextLine();
				mm.delete(title);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break program;
			default:
				System.out.println("번호를 잘못 입력하셨습니다. \n\n\n");
				break;

			}
		}

	}
}
