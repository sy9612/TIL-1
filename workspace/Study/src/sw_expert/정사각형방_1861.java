package sw_expert;

import java.util.*;

public class 정사각형방_1861 {
	static int N;
	static int[][] arr;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] check;
	static boolean[][] m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();

			arr = new int[N][N];
			check = new int[N][N];
			m = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int x = 1000;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(m[i][j] == false) {
						check = new int[N][N];
						dfs(i, j, 1);
						int buf = print(check);
						if (max <= buf) {
							if (max < buf)
								x = arr[i][j];
							else if (max == buf && x > arr[i][j]) {
								x = arr[i][j];
							}
							max = buf;

						}
					}
				}
			}
			
			System.out.println(x + " " + max);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		
		check[x][y] = cnt;
		m[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int r = x + dr[i];
			int c = y + dc[i];

			if (r >= 0 && c >= 0 && r < N && c < N) {
				if (check[r][c] == 0 && arr[r][c] == arr[x][y] + 1) {
					dfs(r, c, cnt + 1);
				}
			}
		}
	}

	static int print(int[][] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			// System.out.println(Arrays.toString(arr[i]));
			for (int j = 0; j < arr.length; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}
	//	System.out.println();
		return max;
	}
}
