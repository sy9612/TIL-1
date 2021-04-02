package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

class dot2 {
	int i = 0;
	int j = 0;
	dot2(int i, int j) {
		this.i = i;
		this.j = j;
	};
}

public class 섬의_개수_4963 {

	static boolean check[][];
	static int w;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			h = sc.nextInt();
			w = sc.nextInt();

			if (w == 0 && h == 0)
				return;
			if (w == 0 || h == 0) {
				System.out.println(0);
				continue;
			}

			int map[][] = new int[w][h];
			check = new boolean[w][h];

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (check[i][j] == false && map[i][j] == 1) {
						dot2 buf = new dot2(i, j);
						bfs(map, buf);
						result++;
					}
				}
			}
			System.out.println(result);

		}
	}

	private static void bfs(int[][] map, dot2 buf) {
		// TODO Auto-generated method stub
		LinkedList<dot2> q = new LinkedList<>();
		check[buf.i][buf.j] = true;
		q.add(buf);
		int dr[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int dc[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
		while (!q.isEmpty()) {
			dot2 ndot = q.poll();
			for (int i = 0; i < 8; i++) {
				int r = ndot.i + dr[i];
				int c = ndot.j + dc[i];

				if (r >= 0 && c >= 0 && r < w && c < h && check[r][c] == false && map[r][c] == 1) {
					check[r][c] = true;
					dot2 n = new dot2(r, c);
					q.add(n);
				}
			}
		}

	}

}
