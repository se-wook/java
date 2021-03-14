package fillCell;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 좌표에서 지정한 칸수까지 상하좌우로 1 채우기
 * 입력 :
 *  배열의 개수   row좌표, column좌표, 칸수
 *  ex) 8  1  1  3
 * 
 */
public class FillCell04 {
	static int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int count = sc.nextInt();
		
		for(int i=0;i<4;i++) {
			for(int j=1;j<=count;j++) {
				int nr = r+dx[i]*j, nc = c+dy[i]*j;
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				map[nr][nc] = 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
