package fillCell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표의 상하좌우에  1을 표시하기 
 * 입력 :
 *  다음줄 부터 :  배열의 개수  좌표개수  {row좌표, column좌표}*좌표개수
 *  8 4 1 1 3 1 3 3 4 2
 * 
 */
public class FillCell05 {
	static int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int p = sc.nextInt();  //좌표 개수
		int r[] = new int[N];
		int c[] = new int[N];
		for(int i=0;i<p;i++) {
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		
		for(int d=0;d<N;d++) {
			for(int i=0;i<4;i++) {
				int nr = r[d]+dx[i], nc = c[d]+dy[i];
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
