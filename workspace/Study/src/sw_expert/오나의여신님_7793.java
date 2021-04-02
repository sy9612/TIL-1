package sw_expert;

import java.util.*;

public class 오나의여신님_7793 {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int max;

	static class Node {
		int i;
		int j;
		int t;
		boolean water;

		Node(int i, int j, int t, boolean ok) {
			this.i = i;
			this.j = j;
			this.t = t;
			this.water = ok;
		};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();

		char map[][] = new char[R][C];

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String buf = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = buf.charAt(j);
				if (map[i][j] == 'S') {
					q.add(new Node(i, j, 0, false));
				} else if (map[i][j] == '*') {
					q.add(new Node(i, j, 0, true));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		outer: while (!q.isEmpty()) {
			Node front = q.poll();

			// 자식 탐색 - 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = front.i + dr[d];
				int nc = front.j + dc[d];

				if (IsIn(map, nr, nc)) { // 범위 안에 있을 때
					if (front.water) {
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							// 지도의 상태를 변경한 것이 방문 처리
							map[nr][nc] = '*';
							// 큐에 새로 들어가긴 하지만 빠지지는 않는다.
							q.offer(new Node(nr, nc, front.t + 1, true));
						}
					} else {
						if (map[nr][nc] == 'D') {
							min = front.t + 1;
							break outer;
						} else if (map[nr][nc] == '.') {
							map[nr][nc] = 'S';

							q.offer(new Node(nr, nc, front.t + 1, false));
						}
					}
				}
			}

		}
		System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
	}

	private static boolean IsIn(char[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
