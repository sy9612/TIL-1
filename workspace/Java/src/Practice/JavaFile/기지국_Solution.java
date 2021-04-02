package Practice.JavaFile;

import java.util.Scanner;

public class 기지국_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char map[][] = new char[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					map[r][c] = sc.next().charAt(0);
				}
			}
			int dr[] = {1,-1,0,0};
			int dc[] = {0,0,1,-1};
			for(int r =0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(map[r][c] == 'B') {
						for(int k=0; k<4; k++) {
							int nr = r+dr[k];
							int nc = c+dc[k];
							if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc] != 'B') {
								map[nr][nc] = 'Y';
							}
						}
					}
				}
			}
		}
	}

}
