package sw_expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거_1953 {
	private static int N;
	private static int M;
	private static int R;
	private static int C;
	private static int L;
	private static int[][] map;

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt(); // 탈주범 시작 위치 R, C
			C = sc.nextInt();
			L = sc.nextInt(); // 소요 시간
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(R, C));

			int[][][] ternal = { { { 0, 0 }, { 0, 0 } }, { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } }, { { 1, -1 }, { 0, 0 } },
					{ { 0, 0 }, { 1, -1 } }, { { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } },
					{ { -1, 0 }, { 0, -1 } } };

			boolean check[][] = new boolean[N][M];
			check[R][C] = true;
			int time = 0;
			int ans = 1;
			while (!q.isEmpty()) {
				int size = q.size();
				time++;
				if (time == L)
					break;

				for (int s = 0; s < size; s++) {
					Node esc = q.poll();
					for (int d = 0; d < ternal[map[esc.i][esc.j]][0].length; d++) {
						int r = esc.i + ternal[map[esc.i][esc.j]][0][d];
						int c = esc.j + ternal[map[esc.i][esc.j]][1][d];

						if (IsIn(map, r, c) && map[r][c] != 0 && !check[r][c]) {
							// 아래
							if (ternal[map[esc.i][esc.j]][0][d] == 1) {
								if (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 4 || map[r][c] == 7) {
									q.add(new Node(r, c));
									check[r][c] = true;
									ans++;
								}
							}
							// 위
							else if (ternal[map[esc.i][esc.j]][0][d] == -1) {
								if (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 5 || map[r][c] == 6) {
									q.add(new Node(r, c));
									check[r][c] = true;
									ans++;
								}
							}
							// 오른
							else if (ternal[map[esc.i][esc.j]][1][d] == 1) {
								if (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 6 || map[r][c] == 7) {
									q.add(new Node(r, c));
									check[r][c] = true;
									ans++;
								}
							}
							// 왼
							else if (ternal[map[esc.i][esc.j]][1][d] == -1) {
								if (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 4 || map[r][c] == 5) {
									q.add(new Node(r, c));
									check[r][c] = true;
									ans++;
								}
							}

						}
					}
				}
			}

			System.out.println(ans);

		}
	}

	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
