package BAEKJOON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈_2636 {
	private static int N;
	private static int M;
	private static int[][] map;

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

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		boolean f = false;
		int result = 0;
		int time = 0;
		while (!f) {
			time ++ ;
			f = true;
			boolean visited[][] = new boolean[N][M];
			Queue<Node> q = new LinkedList<>();
			
			// 외부 공기 체크
			q.add(new Node(0, 0));
			while (!q.isEmpty()) {
				Node buf = q.poll();

				for (int i = 0; i < 4; i++) {
					int r = buf.i + dr[i];
					int c = buf.j + dc[i];

					if (IsIn(map, r, c) && !visited[r][c] && map[r][c] == 0) {
						visited[r][c] = true;
						q.add(new Node(r, c));
					}
				}
			}

			int cnt = 0;
			// 치즈 체크
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1) {
						f = false;
						cnt++;
						for (int d = 0; d < 4; d++) {
							int r = i + dr[d];
							int c = j + dc[d];

							if (IsIn(map, r, c) && visited[r][c] && map[r][c] == 0) {
								map[i][j] = -1; // 녹아야 할 치즈
								continue;
							}
						}
					}
				}
			}
			if(cnt != 0)
				result = cnt;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == -1)
						map[i][j] = 0;
				}
			}
		}
		System.out.println(time-1);
		System.out.println(result);
	}
}
