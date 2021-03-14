package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {
	static int dx[] = {0,-1,1,0,0}, dy[] = {0,0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			int[][] mat = new int[N][N];
			int x[] = new int[W];
			int y[] = new int[W];
			int d[] = new int[W];
			for (int i = 0; i < W; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				d[i] = sc.nextInt();
			}
			int[][] overlap = new int[N][N];
			for (int i = 0; i < W; i++) {
				int nx = x[i], ny = y[i];
				for (int dis = 3; dis >= 1; dis--) {
					nx += dx[d[i]]*dis;
					ny += dy[d[i]]*dis;
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || overlap[nx][ny] == 1) break;
					if(dis == 1) overlap[nx][ny] = 1;
				}
			}
			int ans = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(overlap[i][j] == 1) ans++;
				}
			}
			
			System.out.println("#" + t + " " +ans);
		}
	}
}
