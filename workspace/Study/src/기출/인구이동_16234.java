package 기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동_16234 {
	static int N, L, R;
	static int[][] arr;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

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
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		// bfs
		while (true) {
			Queue<Node> q = new LinkedList<>();
			boolean visited[][] = new boolean[N][N];
			boolean sign = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (visited[i][j] == true)
						continue;
					
					
					Queue<Node> qq = new LinkedList<>();
					int totalPerson = 0;
					int totalFrom = 0;
					q.add(new Node(i, j));
					qq.add(new Node(i, j));
					visited[i][j] = true;

					while (!q.isEmpty()) {
						Node buf = q.poll();
						totalFrom++;
						totalPerson += arr[buf.i][buf.j];
						for (int d = 0; d < 4; d++) {
							int r = buf.i + dr[d];
							int c = buf.j + dc[d];

							if (IsIn(arr, r, c) && visited[r][c] == false) {
								int b = Math.abs(arr[buf.i][buf.j] - arr[r][c]);
								if (b >= L && b <= R) {
									sign = true;
									visited[r][c] = true;
									q.add(new Node(r, c));
									qq.add(new Node(r, c));
								}
							}
						}
					}

					int insert = totalPerson / totalFrom;
					while (!qq.isEmpty()) {
						Node buf = qq.poll();
						arr[buf.i][buf.j] = insert;
					}

				}
			}
			if(sign == true)
				result++;

			if (check()) 
				break;
		}
		System.out.println(result);
	}

	private static boolean check() {
		boolean visit[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = true;
				for (int d = 0; d < 4; d++) {
					int r = i + dr[d];
					int c = j + dc[d];

					if (IsIn(arr, r, c) && visit[r][c] == false) {
						if (Math.abs(arr[i][j] - arr[r][c]) >=L && Math.abs(arr[i][j] - arr[r][c]) <= R) {
							return false;
						}
					}
				}

			}
		}
		return true;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
