package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 감시_15683 {
	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		};
	}

	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0)
					q.add(new Node(i, j));
			}
		}
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		while (!q.isEmpty()) {
			Node peek = q.poll();
			switch (map[peek.i][peek.j]) {
			case 1:
				for (int d = 0; d < dc.length; d++) {

					int cnt = 0;

					for (int k = 1; k < Math.max(N, M); k++) {

						int r = peek.i + dr[d] * k;
						int c = peek.i + dr[d] * k;

						if (IsIn(map, r, c) && map[r][c] != 6) {
							cnt++;
						}
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}

	}
}
