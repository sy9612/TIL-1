package sw_expert;

import java.util.Scanner;

public class 최장경로_2814 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");

			int N = sc.nextInt();
			int M = sc.nextInt();
			if(M == 0) {
				System.out.println(1);
				continue;
			}
			 graph = new int[N][N];
			 max = 0;

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			
			for(int i=0; i<N; i++) {
				visited = new boolean[N];
				dfs(i, 0);
			}
			
			System.out.println(max+1);
		}
	}
	static int graph[][];
	static boolean visited[];
	static int max = 0;
	private static void dfs(int idx, int cnt) {
		if(max < cnt)
			max = cnt;
		
		for(int i=0; i<visited.length; i++) {
			if(graph[idx][i] == 1) {
				if(visited[i] == false) {
					visited[idx] = true;
					dfs(i,cnt+1);
					visited[idx] = false;
				}
			}
		}
	}
}
