package fillCell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표 상하 좌우에 지정한 칸수까지 1을 누적한 후 
 * 누적 값 중에 최대값 출력하기
 * 
 * 입력 :
 *  다음줄 부터 :  배열의 개수  좌표개수  {row좌표, column좌표}*좌표개수
 *  8 4 3 1 1 3 1 3 3 4 2
 * 
 */
public class FillCell08 {
	static int AnswerN;
	static int dx[] = { 0, 0, -1, 1 }, dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner("8 4 3 1 1 3 1 3 3 4 2");
//		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int p = sc.nextInt(); // 좌표 개수
		int count = sc.nextInt(); // 칸수

		int r[] = new int[p];
		int c[] = new int[p];
		for (int i = 0; i < p; i++) {
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}

		for (int d = 0; d < p; d++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= count; j++) {
					int nr = r[d] + dx[i]*j, nc = c[d] + dy[i]*j;
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					map[nr][nc] += 1;
					AnswerN = (AnswerN < map[nr][nc]) ? map[nr][nc] : AnswerN;
				}
			}
		}
			
		System.out.println("최대 누적 :"+AnswerN);
		
	}
}
