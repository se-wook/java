package fillCell;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11_sol3 {
	static int T, N;
	static int Answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][][] dir = {{{0,1}}							//A
						,{{0,1},{0,-1}}						//B
						,{{0,1},{0,-1},{-1,0},{1,0}}};		//C
		
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
					n = robot-'A';
					if(n<3) {
						for (int k = 0; k < dir[n].length; k++) {
							nr = r;
							nc = c;
							while(true){
								nr += dir[n][k][0];
								nc += dir[n][k][1];
								if(nr >= 0 && nr <N && nc>=0 
								  && nc <N && map[nr][nc]=='S') {
									Answer++;
								}else {
									break;
								}
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}