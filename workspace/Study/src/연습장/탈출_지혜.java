package 연습장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_지혜 {
	public static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		boolean check = false;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		// 물 확산 경로가 들어갈 큐
		Queue<Pair> water = new LinkedList<Pair>();
		// 고슴도치 이동 경로가 들어갈 큐
		Queue<Pair> hedgehog = new LinkedList<Pair>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S') {
					hedgehog.offer(new Pair(i, j));
				} else if (map[i][j] == '*') {
					water.offer(new Pair(i, j));
				}
			}
		}
		int cnt = 0;
		while (!hedgehog.isEmpty()) {
			cnt++;
			// BFS로 물 확산. 확산하면서 고슴도치나 빈칸을 영역으로 만듦
			int size = water.size();
			while (size-- > 0) {
				Pair p = water.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							map[nr][nc] = '*';
							water.offer(new Pair(nr, nc));
						}
					}
				}
			}
			// BFS 고슴도 치 이동
			size = hedgehog.size();
			while (size-- > 0) {
				Pair p = hedgehog.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (map[nr][nc] == 'D') {
							sb.append(cnt).append('\n');
							check = true;
						}
						if (map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							hedgehog.offer(new Pair(nr, nc));
						}
					}
				}
			}
		}
		if (check == false)
			sb.append("KAKTUS").append('\n');
		System.out.println(sb);
	}

}