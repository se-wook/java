package chapter09;

import java.util.Scanner;

public class RobotDistance {

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
					if(mat[i][j] == 'A') {
						int cnt = 0;
						int nj = j;
						while(true) {
							nj += 1;
							if(nj >= N || mat[i][nj] != 'S') {
								break;
							}
							cnt++;
						}
						ans += cnt;
					}else if(mat[i][j] == 'B') {
						int cnt = 0;
						int nj = j;
						while(true) {
							nj += 1;
							if(nj >= N || mat[i][nj] != 'S') {
								break;
							}
							cnt++;
						}
						nj = j;
						while(true) {
							nj -= 1;
							if(nj < 0 || mat[i][nj] != 'S') {
								break;
							}
							cnt++;
						}
						ans += cnt;
					}else if(mat[i][j] == 'C') {
						int cnt = 0;
						int nj = j, ni = i;
						while(true) {
							nj += 1;
							if(nj >= N || mat[i][nj] != 'S') {
								break;
							}
							cnt++;
						}
						nj = j;
						while(true) {
							nj -= 1;
							if(nj < 0 || mat[i][nj] != 'S') {
								break;
							}
							cnt++;
						}
						while(true) {
							ni += 1;
							if(ni >= N || mat[ni][j] != 'S') {
								break;
							}
							cnt++;
						}
						ni = i;
						while(true) {
							ni -= 1;
							if(ni < 0 || mat[ni][j] != 'S') {
								break;
							}
							cnt++;
						}
						ans += cnt;
					}
				}
			}
			System.out.println("#" +tc + " " + ans);
		}
	}

}
