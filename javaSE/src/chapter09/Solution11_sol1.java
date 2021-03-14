package chapter09;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11_sol1 {
	static int T, N;
	static int Answer;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
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
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					char robot=map[i][j];
					if(robot=='A'){
						for(int k=j+1; k<N; k++){
							if(map[i][k]=='A'||map[i][k]=='B'||map[i][k]=='C'||map[i][k]=='W'){
								break;
							}else if(map[i][k]=='S'){
								Answer++;
							}
						}
					}else if(robot=='B'){
						for(int k=j+1; k<N; k++){
							if(map[i][k]=='A'||map[i][k]=='B'||map[i][k]=='C'||map[i][k]=='W'){
								break;
							}else if(map[i][k]=='S'){
								Answer++;
							}
						}
						for(int k=j-1; k>=0; k--){
							if(map[i][k]=='A'||map[i][k]=='B'||map[i][k]=='C'||map[i][k]=='W'){
								break;
							}else if(map[i][k]=='S'){
								Answer++;
							}
						}
					}else if(robot=='C'){
						for(int k=j+1; k<N; k++){
							if(map[i][k]=='A'||map[i][k]=='B'||map[i][k]=='C'||map[i][k]=='W'){
								break;
							}else if(map[i][k]=='S'){
								Answer++;
							}
						}
						for(int k=j-1; k>=0; k--){
							if(map[i][k]=='A'||map[i][k]=='B'||map[i][k]=='C'||map[i][k]=='W'){
								break;
							}else if(map[i][k]=='S'){
								Answer++;
							}
						}
						for(int k=i+1; k<N; k++){
							if(map[k][j]=='A'||map[k][j]=='B'||map[k][j]=='C'||map[k][j]=='W'){
								break;
							}else if(map[k][j]=='S'){
								Answer++;
							}
						}
						for(int k=j-1; k>=0; k--){
							if(map[k][j]=='A'||map[k][j]=='B'||map[k][j]=='C'||map[k][j]=='W'){
								break;
							}else if(map[k][j]=='S'){
								Answer++;
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}