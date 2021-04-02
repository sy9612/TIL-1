package 기출;

import java.util.*;

public class 테트로미노_14500 {
	
	// static = 전역변수
	static int max = 0;
	static int N;
	static int M;
	static int arr[][];
	
	
	// 무식하게
	// dfs, bfs --> 안됨
	
	// 델타좌표
	static int dr[][] = {{0, 0, 0, 0}, {0, 1,2,3}, //일자
			{0, 0, 1, 1}, //네모
			{0, 1, 2, 2}, {0, 0, 1, 2}, { 0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, -1}, {0, 0, 0, 1}, {0,0,-1,-2}, {0, 0, 1, 2},
			{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 2, 1}, {0, 0, 0, -1},
			{0, 1, 1, 2}, { 0, 1, 1, 2},{0,0,1,1}, {0,0,1,1}};
	static int dc[][] = {{0, 1, 2, 3}, {0 ,0 ,0 ,0},
			{ 0, 1,0,1}, 
			{0, 0, 0, 1}, {0, 1, 1, 1}, {0,0,1,2}, {0, 1, 2, 2}, {0, 1, 2, 2}, {0, 1, 2, 0}, {0, 1,1,1}, {0,1,0,0},
			{0, 1, 2, 1}, { 0, 0, 0, 1},{0, 0, 0,  -1}, { 0, 1, 2, 1},
			{0, 0, 1, 1}, {0,0,-1,-1}, {1, 0, 0, -1}, {-1,0,0,1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //cin>>N
		M = sc.nextInt();

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt(); //arr[i][j] 각각 좌표 넣어준거
			}
		}
		//입력완료
		
		//시작점
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//테트로미노 개수만큼				
				for(int k=0; k<19; k++) {
					int sum = 0;
					int cnt = 0;
					
					//4개의 좌표
					for(int l=0; l<4; l++) {
						int r = i+dr[k][l];
						int c = j+dc[k][l];
						
						if(r<0||c<0|| r>=N|| c>=M)
							continue;
						cnt++;
						sum += arr[r][c];
					}
					
					if(cnt == 4 && max < sum)
						max = sum;
				}
			}
		}

		System.out.println(max);

	}

}
