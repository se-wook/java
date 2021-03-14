package fillCell;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21_sol3 {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution21.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
//					     1:아래쪽   2:오른쪽
		int[][] dir= {{},{1,0}  ,{0,1}};
		for(int test_case=1; test_case<=T; test_case++){
			N=sc.nextInt(); 
			int[][] lake=new int[N][N];
			S=sc.nextInt();
			int[][] strider=new int[S][3];
			for(int k=0; k<S; k++){
				strider[k][0]=sc.nextInt();
				strider[k][1]=sc.nextInt();
				strider[k][2]=sc.nextInt();
			}
			Answer=0;
			int k=0, r, c, d;
			first:
			for(k=0; k<S; k++){
				r=strider[k][0];  
				c=strider[k][1];  
				d=strider[k][2]; 
				if(r>=0 && r<N && c>=0 && c<N){
					if(lake[r][c]==1) break;  
					lake[r][c]=1;  
					for(int l=3; l>=1; l--){
						r+=dir[d][0]*l;
						c+=dir[d][1]*l;
						if(r<N && c<N){
							if(lake[r][c]==1) {
								break first;
							}
							lake[r][c]=1;
						}
					}
				}
			}
			if(k<S) Answer=k+1;
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
