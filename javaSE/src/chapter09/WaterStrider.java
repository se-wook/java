package chapter09;

import java.util.Scanner;

public class WaterStrider {
	static int dx[] = { 0, 1, 0 }, dy[] = { 0, 0, 1 };

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
			int ans = 0;		
			outside:
			for (int i = 0; i < W; i++) {
				int nx = x[i], ny = y[i];
				for (int dis = 3; dis >= 1; dis--) {
					nx += dx[d[i]]*dis;
					ny += dy[d[i]]*dis;
					if(nx >= N || ny >= N) break;
					overlap[nx][ny] += 1;
					if(overlap[nx][ny] > 1) {
						ans = i+1;
						break outside;
					}
				}
			}
			System.out.println("#" + t + " " +ans);
		}
	}

}
