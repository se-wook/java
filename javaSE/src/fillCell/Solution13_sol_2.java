package fillCell;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13_sol_2 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			char[][] area = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}

			int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
			int nr, nc;
			int high = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num = 0;
					boolean isG = false;
					if (area[r][c] == 'B') {
						for (int i = 0, n = pos.length; i < n; i++) {
							nr = r + pos[i][0];
							nc = c + pos[i][1];
							if (nc >= 0 && nr >= 0 && nc < N && nr < N) {
								if (area[nr][nc] == 'G') {
									isG = true;
									num = 2;
									if (num > high)
										high = num;
									break;
								}
							}
						}
						if (!isG) {
							num = 0;
							for (int j = 0; j < N; j++) {
								if (area[r][j] == 'B') {
									num++;
								}
								if (area[j][c] == 'B') {
									num++;
								}
							}
							num--;
						}
						if (num > high)
							high = num;
					}
				}
			}

//			System.out.println(high);
			System.out.println("#" + test_case + " " + high);
		}
	}
}