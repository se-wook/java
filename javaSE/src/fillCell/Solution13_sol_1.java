package fillCell;
import java.io.FileInputStream;
import java.util.Scanner;

// B구획의 빌딩 최고 높이 구하기
public class Solution13_sol_1 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[][] area=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			Answer=0;
			int count=0;
			for(int i=0; i<N; i++) {     //모든 구획을 검색
				for(int j=0; j<N; j++) {
					int g=0;
					if(area[i][j]=='B')	{  //B구획이 아니면 다음 구획으로
						if(Answer==0) Answer=2;          // B구획이라 일단 2층으로 초기화

						//팔방이 경계내에 있고 B인지 확인, B가 아니라면 다음구획으로
						if(i-1>=0 && area[i-1][j]=='G') g++;//상
						if(i-1>=0 && j+1<N && area[i-1][j+1]=='G')g++; //우상
						if(j+1<N && area[i][j+1]=='G')g++; //우
						if(i+1<N && j+1<N &&area[i+1][j+1]=='G')g++; //우하
						if(i+1<N && area[i+1][j]=='G')g++; //하
						if(i+1<N && j-1>=0 && area[i+1][j-1]=='G')g++; //좌하
						if(j-1>=0 && area[i][j-1]=='G')g++;  //좌
						if(i-1>=0 && j-1>=0 && area[i-1][j-1]=='G')g++;  //좌상

						if(g==0){
							//인접한 구획에 G가 없을 경우 가로행, 세로열에 있는 B구획을 count
							count=0;  // clear
							for(int k=0; k<N; k++){//세로열 B구획 세기
								if(area[k][j]=='B'){
									count++;
								}
							}
							for(int k=0; k<N; k++){//가로행 B구획 세기
								if(area[i][k]=='B'){
									count++;
								}
							}
							count--;// 자신 중복제거
							if(count>Answer) Answer=count;
						}
					}//end if B
				}//end for j
			}//end for i

			System.out.println("#"+test_case+" "+Answer);
		}//end testcase
	}
}