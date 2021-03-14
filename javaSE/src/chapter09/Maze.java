package chapter09;

import java.util.Scanner;

public class Maze {
	static int dr[]= {0,-1,0,1,0}, dc[] = {0,0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int J = sc.nextInt();
			int[][] m = new int[N+1][N+1];
			for(int i=0;i<J;i++) {
				int r, c;
				r = sc.nextInt();
				c = sc.nextInt();
				m[r][c] = 1;
			}
			int D = sc.nextInt();
			int[] dir = new int[D];
			int[] cnt = new int[D];
			for(int i=0;i<D;i++) {
				dir[i] = sc.nextInt();
				cnt[i] = sc.nextInt();
			}
			int ansR = 0, ansC = 0;
			int nr = R, nc = C;
			for(int i=0;i<D;i++) {
				for(int j=1;j<=cnt[i];j++) {
					nr += dr[dir[i]];
					nc += dc[dir[i]];
					if(nr < 1 || nr > N || nc < 1 || nc > N || m[nr][nc] == 1) {
						ansR = 0;
						ansC = 0;
						break;
					}
					ansR = nr;
					ansC = nc;
				}
			}
			System.out.println("#" +t + " " + ansR + " " + ansC);
		}
	}

}
