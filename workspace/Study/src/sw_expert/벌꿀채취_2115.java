package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 벌꿀채취_2115 {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			 N = sc.nextInt();
			 M = sc.nextInt();
			 C = sc.nextInt();

			map = new int[N][N];
			max = 0;
			combr =  new int[2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			
			comb(0,0);
			System.out.println(max);

		}

	}
	static int combr[];
	private static void comb(int idx, int jdx) {
		if(jdx == 2) {
			
			int x1 = combr[0]/N;
			int y1 = combr[0]%N;
			
			int x2 = combr[1]/N;
			int y2 = combr[1]%N;
			
			boolean visited[][] = new boolean[N][N];
	
			int man1[] = new int[M];
			
			for(int i=0; i<M; i++) {
				if(y1+i >= N) return;
				visited[x1][y1+i] = true;
				man1[i] = map[x1][y1+i];
			}
			
			int man2[] = new int[M];
			for(int i=0; i<M; i++) {
				if(y2+i >= N) return;
				if(visited[x2][y2+i]) return;
				man2[i] = map[x2][y2+i];
			}
			
			
			//비트마스크
			int max1 = 0;
			for(int i=0; i< (1<<man1.length); i++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int j=0; j<man1.length; j++) {
					if( (i & (1<<j)) != 0 ){
						sum2 += man1[j];
						sum1 += (man1[j] * man1[j]);
					}
					
				}
				if(sum2 <= C &&max1 < sum1)
				{
					max1 = sum1;
				}
			}
			int max2 = 0;
			for(int i=0; i< (1<<man2.length); i++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int j=0; j<man2.length; j++) {
					if( (i & (1<<j)) != 0 ){
						sum2 += man2[j];
						sum1 += (man2[j] * man2[j]);
					}
				}
				if(sum2 <= C && max2 < sum1)
				{
					max2 = sum1;
				}
			}
			
			if(max < (max1 + max2)) {
				max = max1+max2;
			}
			
			return;
		}
		if(idx == N*N) {
			return;
		}
		
		combr[jdx] = idx;
		comb(idx+1, jdx+1);
		comb(idx+1, jdx);
	}
}
