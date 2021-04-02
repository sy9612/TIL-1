package 이것이코딩테스트다;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 화성탐사 {
	static class Node implements Comparable<Node> {
		int d;
		int r;
		int c;

		Node(int d, int r, int c) {
			this.d = d;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d == o.d) {
				if (this.r == o.r) {
					return this.c - o.c;
				}
				return this.r - o.r;
			}
			return this.d - o.d;
		}

	

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int[][] d = new int[N][N];

			for (int i = 0; i < d.length; i++) {
				Arrays.fill(d[i], Integer.MAX_VALUE);
				
			}

			d[0][0] = 0;

			PriorityQueue<Node> pq = new PriorityQueue<>();

			pq.add(new Node(0, 0, 0));

			int dr[] = { 0, 0, 1, -1 };
			int dc[] = { 1, -1, 0, 0 };

			while (!pq.isEmpty()) {
				Node buf = pq.poll();
				
				if(buf.r == N-1 && buf.c == N-1)
					break;

				for (int i = 0; i < 4; i++) {
					int r = buf.r + dr[i];
					int c = buf.c + dc[i];

					if (r < 0 || c < 0 || r >= N || c >= N) {
						continue;
					}
					
					
					if(d[r][c] > d[buf.r][buf.c] + map[r][c])
					{
						d[r][c] = d[buf.r][buf.c] + map[r][c];
						pq.add(new Node(d[r][c], r, c));
					}
					
				}
			}
			
			System.out.println(map[0][0] + d[N-1][N-1]);
		}
	}
}
