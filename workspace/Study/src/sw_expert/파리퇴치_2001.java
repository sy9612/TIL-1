package sw_expert;

import java.util.Scanner;

public class 파리퇴치_2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int map[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					int cnt = 0;
					for(int mi=i; mi<M+i; mi++) {
						for(int mj=j; mj<M+j; mj++) {
							if(mi>=0 && mj>=0 && mi<N && mj <N)
								cnt += map[mi][mj];
						}
					}
					
					if(max<cnt)
						max = cnt;
				}
			}
			
			System.out.println(max);
		}
	}

}
