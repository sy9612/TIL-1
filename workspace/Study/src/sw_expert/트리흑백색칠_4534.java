package sw_expert;

import java.util.Scanner;

public class 트리흑백색칠_4534 {
	static int N;
	static int[][] M;
	static int[][] V;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();

			M = new int[N + 1][N + 1];
			V = new int[N + 1][N + 1];

			for (int i = 0; i < N - 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				M[a][b] = 1;
				M[b][a] = 1;
			}
			dfs(0, 0);
		}
	}

	private static void dfs(int x, int y) {
		
		
	}

}
