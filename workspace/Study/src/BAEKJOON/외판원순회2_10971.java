package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 외판원순회2_10971 {
	private static int[][] map;
	private static boolean[] visited;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			perm(i, 0, 0, i);

		}

		System.out.println(min != Integer.MAX_VALUE ? min : 0);

	}

	static int min = Integer.MAX_VALUE;

	private static void perm(int idx, int cnt, int sum, int st) {
		// TODO Auto-generated method stub
		if (idx >= N)
			return;

		if (cnt == N - 1) {
			if (map[idx][st] != 0) {
				min = Math.min(min, sum + map[idx][st]);
//				System.out.println(min + "--");
			}
			return;
		}

		visited[idx] = true;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[idx][i] != 0) {
				visited[i] = true;
//				System.out.println(idx + " " + i + " " + map[idx][i]);
				perm(i, cnt + 1, sum + map[idx][i], st);
				visited[i] = false;
			}
		}
	}
}
