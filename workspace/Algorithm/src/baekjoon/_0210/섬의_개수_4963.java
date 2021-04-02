package baekjoon._0210;

import java.util.Scanner;

class Node {
	int i;
	int j;

	Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class 섬의_개수_4963 {
	static boolean check[][];
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0)
				break;
			if (w == 0 || h == 0)
				continue;

			map = new int[h][w];
			check = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && check[i][j] == false) {
						dfs(new Node(i, j));
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void dfs(Node node) {
		// TODO Auto-generated method stub
		check[node.i][node.j] = true;

		int dr[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int dc[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

		for (int i = 0; i < 8; i++) {
			int r = dr[i] + node.i;
			int c = dc[i] + node.j;

			if (r >= 0 && c >= 0 && r < map.length && c < map[r].length) {
				if (map[r][c] == 1 && check[r][c] == false)
					dfs(new Node(r, c));
			}
		}
	}
}
