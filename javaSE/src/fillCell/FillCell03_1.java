package fillCell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 경계 검사
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3 0 0 
 * 
 */
public class FillCell03_1 {
	
	static int dx[] = {0,0,-1,1,1,1,-1,-1}, dy[] = {-1,1,0,0,1,-1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();

		for(int i=0;i<8;i++) {
			int nr = r+dx[i], nc = c+dy[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			map[nr][nc] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
