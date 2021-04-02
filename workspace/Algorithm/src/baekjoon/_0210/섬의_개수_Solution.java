package baekjoon._0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의_개수_Solution {
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if (N == 0 && M == 0)
				break;
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();

				}
			}
			int cnt = 0;
			// 맵을 한바퀴 쭉 돌면서 육지를 만날 때마다 카운트++
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						cnt++;
						// 해당 육지와 연결된 모든 육지를 0으로 바꿈
						// dfs(i,j);
						// bfs
						Queue<Node> queue = new LinkedList<>();
						//시작점을 큐에 넣음
						queue.add(new Node(i,j));
						//큐가 빌 때 까지
						//큐에서 하나 꺼내서, 현재 노드의 8방에 대해 육지가 존재하면 큐에 넣음
						while(!queue.isEmpty()) {
							Node node = queue.poll();
							//현재 위치를 물로 바꿈
							map[node.r][node.c] = 0;
							for(int d = 0; d<8; d++) {
								int nr = node.r + dr[d];
								int nc = node.c + dc[d];
								if(nr <0 || nc<0 || nr >= N || nc >= M)
									continue;
								if(map[nr][nc] == 0)
									continue;
								queue.add(new Node(nr,nc));
							}
						}
					}
				}
			}
		}
	}

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void dfs(int r, int c) {
		// 물로 바꿈
		map[r][c] = 0;
		// 인접한 8가지 방향에 대해 물로 바꾸는 호출을 불러옴
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 8방에 대해 맵 안에 있고 땅이라면
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

}
