package sw_expert;

import java.util.*;

public class 모래성쌓기_1907 {
	static int H, W;
	static int[][] sea;
	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, -1, 1, 1, -1 };

	static class Node {
		int i = 0;
		int j = 0;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			H = sc.nextInt();
			W = sc.nextInt();
			sea = new int[H][W];

			LinkedList<Node> qq = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				String st = sc.next();
				for (int j = 0; j < W; j++) {
					if (st.charAt(j) == '.') {
						qq.add(new Node(i, j));
						sea[i][j] = '.';
					} else
						sea[i][j] = st.charAt(j) - '0';
				}
			}

			LinkedList<Node> q = new LinkedList<>();
			while (!qq.isEmpty()) {
				Node buf = qq.poll();
				for (int d = 0; d < 8; d++) {
					int r = buf.i + dr[d];
					int c = buf.j + dc[d];

					if (r < 0 || c < 0 || r >= H || c >= W)
						continue;

					if (sea[r][c] != '.' && sea[r][c] != -1) {
						sea[r][c]--;
						if (sea[r][c] == 0) {
							q.add(new Node(r, c));
							sea[r][c] = -1;
						}
					}
				}
			}
			int ans = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Node buf = q.poll();
					for (int d = 0; d < 8; d++) {
						int r = buf.i + dr[d];
						int c = buf.j + dc[d];

						if (r < 0 || c < 0 || r >= H || c >= W)
							continue;

						if (sea[r][c] > 0 && sea[r][c] != '.') {
							sea[r][c]--;	
							if (sea[r][c] == 0) {
								q.add(new Node(r, c));
								sea[r][c] = -1;
							}
						}
					}
				}
				ans++;
			}
			System.out.println(ans);

		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
