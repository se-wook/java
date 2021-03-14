package chapter09;

import java.util.Arrays;
import java.util.Scanner;

public class RobotDistance2 {
	static int d[][] = {
			{1},
			{1,4},
			{1,2,4,8}
	};
	static int dr[] = {0,1,0,-1}, dc[] = {1,0,-1,0}; // 오른 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] mat = new char[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					mat[i][j] = sc.next().charAt(0);
				}
			}
			int ans =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(mat[i][j] != 'W' && mat[i][j] != 'S') {
						int x = mat[i][j]-'A';
						int[] dis = d[x];
						for(int k=0;k<dis.length;k++) {
							for(int l=0;l<4;l++) {
								if(dis[k] == (1 << l)) {
									int nr = i + dr[l], nc = j+dc[l];
									while(true) {
										if(nr < 0 || nr >= N || nc < 0 || nc >= N || mat[nr][nc] != 'S') break;
										ans++;
										nr += dr[l];
										nc += dc[l];
									}
								}
							}
						}
					}
				}
			}
			System.out.println("#" +tc + " " + ans);
		}
	}

}
