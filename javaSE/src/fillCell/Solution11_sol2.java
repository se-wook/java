package fillCell;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11_sol2 {
	static int T, N;
	static int Answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
					//   우        좌            상         하
		int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[][] map=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			Answer=0;
			int n=0, nr, nc;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					char robot=map[r][c];
					if(robot=='A'){
						n = 1;
					}else if(robot=='B'){
						n = 2;
					}else if(robot=='C'){
						n = 4;
					}else {
						continue;
					}
					for (int k = 0; k < n; k++) {
						nr = r;
						nc = c;
						while(true){
							nr += dir[k][0];
							nc += dir[k][1];
							if(nr >= 0 && nr <N && nc>=0 && nc <N && map[nr][nc]=='S') {
								Answer++;
							}else {
								break;
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}