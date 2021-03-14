package fillCell;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21_sol2 {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution21.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
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
			int k=0;
			first:
			for(k=0; k<S; k++){
				int r=strider[k][0];  
				int c=strider[k][1];  
				int dir=strider[k][2]; 
				if(r>=0 && r<N && c>=0 && c<N){
					if(lake[r][c]>=1) break;  
					lake[r][c]++;  
					if(dir==1){
						for(int l=3; l>=1; l--){
							r+=l;
							if(r<N){
								if(lake[r][c]>=1) {
									lake[r][c]++;
									break first;
								}
								lake[r][c]++;							
							}
						}
					}else{//2
						for(int l=3; l>=1; l--){
							c+=l;
							if(c<N){
								if(lake[r][c]>=1) {
									lake[r][c]++;
									break first;
								}
								lake[r][c]++;							
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(lake[i][j]+" ");
				}
				System.out.println();
			}
			if(k<S) Answer=k+1;
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
