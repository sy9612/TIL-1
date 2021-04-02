package Practice.JavaFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class 항공기지건설 {
	static int answer;
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("항공기지건설input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc = 1; tc <= T; tc ++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][N];
			for(int r =0; r<N; r++) {
				for(int c= 0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// 영역 시작점
			for(int r =0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int cnt =0;
					// 영역 끝점
					for (int m = r; m < N; m++) {
						for (int n = c; n < N; n++) {
							// 영역 안에 최대최소
							int max = 0, min = Integer.MAX_VALUE;
							for (int a = r; a <= m; a++) {
								for(int b=c; b<= n; b++) {
									max = Math.max(max, map[a][b]);
									min = Math.min(min, map[a][b]);
											
								}
							}
							//고도차가 범위 안에 존재
							if(Math.abs(max-min) <= K) {
								cnt = Math.abs(m-r+1) * Math.abs(n-c+1);
								answer = Math.max(answer, cnt);
							}
						}
					}
				}
			}
			
			//print(map);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for(int i=0; i<map. length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
