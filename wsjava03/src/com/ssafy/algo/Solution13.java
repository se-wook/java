package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {
	static int dr[] = {0,0,-1,1,1,1,-1,-1}, dc[] = {-1,1,0,0,1,-1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			char[][] mat = new char[N][N];
			boolean[][] check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = sc.next().charAt(0);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(mat[i][j] == 'G') {
						check[i][j] = true;
						for(int k=0;k<8;k++) {
							int nr = i + dr[k], nc = j + dc[k];
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							if(mat[nr][nc] == 'B') check[nr][nc] = true;
						}
					}
				}
			}
			int ans = 2;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int cnt = 0;
					if(check[i][j] == false) {
						for(int r=0;r<N;r++) {
							if(mat[r][j] == 'B') cnt++;
						}
						for(int c=0;c<N;c++) {
							if(mat[i][c] == 'B') cnt++;
						}
					}
					ans = (ans < cnt-1) ? cnt-1 : ans;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
