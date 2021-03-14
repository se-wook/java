package fillCell;

import java.util.Scanner;

/**
 * 초기 좌표에서 이동 경계를 벗어난 경우 out문자 출력 입력 : 
 * 다음줄 부터 : 배열의 개수 초기row좌표, 초기col좌표, 이동 개수 , {이동 방향, 스텝} *n 
 * 1 : 오른쪽 2 : 아래쪽 3 : 왼쪽 4 : 윗쪽
 * 
 * 8 3 3 3 1 1 2 2 1 1 
 * 8 3 1 3 4 2 1 1 4 1
 */
public class FillCell09 {
	static int dx[] = { 0, 1, 0, -1, 0 }, dy[] = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner("8  3 3 3 1 1 2 2 1 1");
//		Scanner sc = new Scanner("8  3 1 3 4 2 1 1 4 1");
//		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int ix = sc.nextInt();
		int iy = sc.nextInt(); // 초기 x,y
		int p = sc.nextInt(); // 좌표 개수

		int dir[] = new int[p];
		int step[] = new int[p];
		for (int i = 0; i < p; i++) {
			dir[i] = sc.nextInt();
			step[i] = sc.nextInt();
		}
		first:
		for (int i = 0; i < p; i++) {
			for(int j=1;j<=step[i];j++) {
				ix += dx[dir[i]]*j;
				iy += dy[dir[i]]*j;
				if (ix < 0 || ix >= N || iy < 0 || iy >= N) {
					System.out.println(ix + " " + iy + " out");
					break first;
				}
				map[ix][iy] = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
