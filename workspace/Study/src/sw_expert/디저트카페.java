package sw_expert;

import java.util.*;

public class 디저트카페 {
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			map = new int[N][N];
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			hash = new int[101];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					hash[map[i][j]] = 1;
					dfs(i, j, 0, 0, 0, 0);
					hash[map[i][j]] = 0;
				}
			}
			System.out.println(max);
		}
	}

	static int max;

	private static void dfs(int x, int y, int d, int cnt, int xcnt, int ycnt) {

		if (d == 4) {
			if (max < cnt)
				max = cnt;
			return;
		}
		int K;
		if (d == 2)
			K = xcnt;
		else if (d == 3)
			K = ycnt;
		else
			K = N;

		for (int i = 1; i <= K; i++) {
			int r = 0, c = 0;
			boolean sign = true;
			for (int j = 1; j <= i; j++) {
				r = x + dr[d] * j;
				c = y + dc[d] * j;

				if(d == 3 && j == ycnt)
					break;
				if (r < 0 || c < 0 || r >= N || c >= N)  {
					sign = false;
					break;
				}
				else if(hash[map[r][c]] == 1) {
					sign = false;
					hash[map[r][c]] += 1;
					break;
				}
				else {
					hash[map[r][c]] = 1;
				}
			}
			if(sign == false) {
			}
			else if (d == 0)
				dfs(r, c, d + 1, cnt + i, i, 0);
			else if (d == 1)
				dfs(r, c, d + 1, cnt + i, xcnt, i);
			else
				dfs(r, c, d + 1, cnt + i, xcnt, ycnt);

			for (int j = 1; j <= i; j++) {
				r = x + dr[d] * j;
				c = y + dc[d] * j;

				if (r < 0 || c < 0 || r >= N || c >= N)
					continue;
				else if(hash[map[r][c]] > 1) {
					hash[map[r][c]] = 1;					
				}
				else if(hash[map[r][c]] == 1)
					hash[map[r][c]] = 0;
			}
		}
	}

	static int hash[];
}
 