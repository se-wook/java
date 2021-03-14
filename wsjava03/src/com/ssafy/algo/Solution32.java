package com.ssafy.algo;

import java.util.Scanner;

public class Solution32 {
	static int dr[] = {0,0,1,0,-1}, dc[] = {0,1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int N = sc.nextInt();
			int[][] mat = new int[R+1][C+1];
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int mr[] = new int[N];
			int mc[] = new int[N];
			int mn[] = new int[N];
			for(int i=0;i<N;i++) {
				mr[i] = sc.nextInt();
				mc[i] = sc.nextInt();
				mn[i] = sc.nextInt();
			}
			int X = sc.nextInt();
			for(int i=0;i<X;i++) {
				int tx = sc.nextInt();
				int ty = sc.nextInt();
				mat[tx][ty] = 0;
			}
			int prize = -1000*N;
			for(int i=0;i<N; i++) {
				int r = mr[i], c = mc[i], n = mn[i];
				int nr = r, nc = c, p = 0;
				while(n > 0) {
					int dir = mat[nr][nc]/10, jump = mat[nr][nc]%10;
					nr += dr[dir]*jump;
					nc += dc[dir]*jump;
					if(nr < 1 || nr > R || nc < 1 || nc > C || mat[nr][nc] == 0) {
						p = 0;
						break;
					}
					n--;
					p = mat[nr][nc] * 100; 
				}
				prize += p;
			}
			
			System.out.println("#" + t + " " + prize);
		}
	}

}
