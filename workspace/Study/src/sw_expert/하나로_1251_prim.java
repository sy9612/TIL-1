package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 하나로_1251_prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int island[][] = new int[N][2];

			for (int i = 0; i < N; i++) {
				island[i][0] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				island[i][1] = sc.nextInt();
			}

			double E = sc.nextDouble();
			long[][] graph = new long[N][N];
			int[] from, to;
			for(int r =0; r< N; r++) {
				from = island[r];
				for(int c = r+1; c<N; c++) {
					to = island[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0]-to[0]) * (from[1]-to[1]) * (from[1]-to[1]);
				}
			}
			
			//prim 알고리즘
			long[] key = new long[N];
			boolean[] visited = new boolean[N];
			int[] p = new int[N];
			
			Arrays.fill(key, Integer.MAX_VALUE);
			
			//아무거나 하나 선택
			p[0] = -1;
			key[0] = 0;
			
			for(int i= 0; i<N-1; i++) {
				long min = Long.MAX_VALUE;
				int index = -1;
				for(int j=0; j<N; j++) {
					if(!visited[j] && key[j] <min) {
						index = j;
						min = key[j];
					}
				}
				visited[index] = true;
				
				for(int j=0; j<N; j++) {
					if(!visited[index] && graph[index][j] != 0 && key[j] > graph[index][j]) {
						p[j] = index;
						key[j] = graph[index][j];
					}
				}
			}
			long result = 0;
			for(int i=0; i<N; i++) {
				result += key[i];
			}
			System.out.println(result);
		}
	}
}
