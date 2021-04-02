package 기출;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 로봇청소기_14503 {

	static class Node {
		int i;
		int j;
		int d;

		Node(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 로봇청소기 위치
		int r = sc.nextInt();
		int c = sc.nextInt();

		// 0 =북 ,1= 동, 2=남, 3=서
		int d = sc.nextInt();

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 1 = 벽, 0 = 빈칸, 2 = 청소o

		int result = 0;

		// bfs
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(r, c, d));
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		boolean end = false;
		while (!q.isEmpty()) {
			if(end)
				break;
			Node buf = q.poll();
			if (map[buf.i][buf.j] == 0) {
				result++;
				map[buf.i][buf.j] = 2;
			}
			boolean t = false;
			switch (buf.d) {
			case 0:
				 t = false;
				for (int dd = 0; dd < 4; dd++) {
					int cr = buf.i + dr[dd];
					int cc = buf.j + dc[dd];

					if (IsIn(map, cr, cc) && map[cr][cc] == 0) {
						t = true;
						break;
					}
				}

				if (t) {
					if (map[buf.i][buf.j - 1] == 0) {
						q.add(new Node(buf.i, buf.j - 1, 3));
					} else {
						q.add(new Node(buf.i, buf.j, 3));
					}
				}
				else {
					if(map[buf.i+1][buf.j] != 1) {
						q.add(new Node(buf.i+1, buf.j, buf.d));
					}
					else {
						end = true;
					}
				}
				break;
			case 1:
				 t = false;
				for (int dd = 0; dd < 4; dd++) {
					int cr = buf.i + dr[dd];
					int cc = buf.j + dc[dd];

					if (IsIn(map, cr, cc) && map[cr][cc] == 0) {
						t = true;
						break;
					}
				}

				if (t) {
					if (map[buf.i-1][buf.j] == 0) {
						q.add(new Node(buf.i-1, buf.j, 0));
					} else {
						q.add(new Node(buf.i, buf.j, 0));
					}
				}
				else {
					if(map[buf.i][buf.j-1] != 1) { //후진
						q.add(new Node(buf.i, buf.j-1, buf.d));
					}
					else {
						end = true;
					}
				}
				break;
			case 2:
				t = false;
				for (int dd = 0; dd < 4; dd++) {
					int cr = buf.i + dr[dd];
					int cc = buf.j + dc[dd];

					if (IsIn(map, cr, cc) && map[cr][cc] == 0) {
						t = true;
						break;
					}
				}

				if (t) {
					if (map[buf.i][buf.j+1] == 0) {
						q.add(new Node(buf.i, buf.j + 1, 1));
					} else  {
						q.add(new Node(buf.i, buf.j, 1));
					}
				}
				else {
					if(map[buf.i-1][buf.j] != 1) {
						q.add(new Node(buf.i-1, buf.j, buf.d));
					}
					else {
						end = true;
					}
				}
				break;
			case 3:
				 t = false;
				for (int dd = 0; dd < 4; dd++) {
					int cr = buf.i + dr[dd];
					int cc = buf.j + dc[dd];

					if (IsIn(map, cr, cc) && map[cr][cc] == 0) {
						t = true;
						break;
					}
				}

				if (t) {
					if (map[buf.i+1][buf.j] == 0) {
						q.add(new Node(buf.i+1, buf.j, 2));
					} else  {
						q.add(new Node(buf.i, buf.j, 2));
					}
				}
				else {
					if(map[buf.i][buf.j+1] != 1) {
						q.add(new Node(buf.i, buf.j+1, buf.d));
					}
					else {
						end = true;
					}
				}
				break;
			}
		}

		System.out.println(result);

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
