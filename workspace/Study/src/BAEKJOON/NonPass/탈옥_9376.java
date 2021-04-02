package BAEKJOON.NonPass;

import java.util.*;

public class 탈옥_9376 {
	static int H, W;
	static char[][] map;

	static class Node {
		int i;
		int j;
		int cnt;
		boolean visit[][];

		Node(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		};

		Node(int i, int j, int cnt, boolean visit[][]) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.visit = visit.clone();
		};
	}

	static LinkedList<Node> tmp;
	static Node jail2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			tmp = new LinkedList<>();

			for (int i = 0; i < H; i++) {
				String st = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = st.charAt(j);

					if (map[i][j] == '$') {
						tmp.add(new Node(i, j, 0, new boolean[H][W]));
					}
				}
			}
			min = Integer.MAX_VALUE;
			Node jail1 = tmp.poll();
			jail2 = tmp.poll();
			dfs(jail1);
			System.out.println(min);
		}
	}

	private static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);

		visited = new boolean[H][W];
		while (!q.isEmpty()) {
			Node jail = q.poll();
			for (int d = 0; d < 4; d++) {
				int r = jail.i + dr[d];
				int c = jail.j + dc[d];
		
				if (IsIn(map, r, c)) {
					if (!visited[r][c]) {
						if (map[r][c] == '*')
							continue;
						if (start.visit[r][c] && map[r][c] == '#') {
							visited[r][c] = true;
							q.add(new Node(r, c, jail.cnt, start.visit));
						} else if (!start.visit[r][c] && map[r][c] == '#') {
							visited[r][c] = true;
							q.add(new Node(r, c, jail.cnt + 1, start.visit));
						} else {
							visited[r][c] = true;
							q.add(new Node(r, c, jail.cnt, start.visit));
						}

					}
				} else {
					if (min > jail.cnt)
						min = jail.cnt;
				}
			}
		}
	}

	static int[] dc = { 0, 0, 1, -1 };
	static int[] dr = { 1, -1, 0, 0 };
	static int min;
	static boolean visited[][];

	private static void dfs(Node start) {
		start.visit[start.i][start.j] = true;

		for (int d = 0; d < 4; d++) {
			int r = start.i + dr[d];
			int c = start.j + dc[d];
			if (IsIn(map, r, c)) {
				if (!start.visit[r][c]) {
					if (map[r][c] == '*')
						continue;
					if (map[r][c] == '#') {
						dfs(new Node(r, c, start.cnt + 1, start.visit));
						start.visit[r][c] = false;
					} else {
						dfs(new Node(r, c, start.cnt, start.visit));
						start.visit[r][c] = false;
					}
				}
			}
			// 탈출
			else {
				jail2.cnt = start.cnt;
				jail2.visit = start.visit;
				bfs(jail2);
			}
		}

	}

	private static boolean IsIn(char[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}

	private static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
