package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

public class 파이프옮기기1_17070 {

	// 가로1 세로2 대각선3
	static class Dot {
		int i;
		int j;
		int dir;

		Dot(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}

	static int N;

	static int[][] map;
	static long result = 0;

	static void dfs(Dot buf) {
		// 가로
		if (buf.j == N - 1 && buf.i == N - 1) {
			result++;
			return;
		}
		if (buf.dir == 1) {
			if (buf.j + 1 >= 0 && buf.j + 1 < N && map[buf.i][buf.j + 1] == 0) {
				dfs(new Dot(buf.i, buf.j + 1, 1));
			}
			if (buf.i + 1 >= 0 && buf.j + 1 >= 0 && buf.i + 1 < N && buf.j + 1 < N && map[buf.i + 1][buf.j + 1] == 0
					&& map[buf.i + 1][buf.j] == 0 && map[buf.i][buf.j + 1] == 0) {
				
					dfs(new Dot(buf.i + 1, buf.j + 1, 3));
			}
		}

		// 세로
		else if (buf.dir == 2) {
			if (buf.i + 1 >= 0 && buf.i + 1 < N && map[buf.i + 1][buf.j] == 0) {
				
					dfs(new Dot(buf.i + 1, buf.j, 2));
			}
			if (buf.i + 1 >= 0 && buf.j + 1 >= 0 && buf.i + 1 < N && buf.j + 1 < N && map[buf.i + 1][buf.j + 1] == 0
					&& map[buf.i + 1][buf.j] == 0 && map[buf.i][buf.j + 1] == 0) {
				
					dfs(new Dot(buf.i + 1, buf.j + 1, 3));
			}
		}

		else if (buf.dir == 3) {
			// 가로
			if (buf.j + 1 >= 0 && buf.j + 1 < N && map[buf.i][buf.j + 1] == 0) {
				
					dfs(new Dot(buf.i, buf.j + 1, 1));
			}
			// 세로
			if (buf.i + 1 >= 0 && buf.i + 1 < N && map[buf.i + 1][buf.j] == 0) {
				
					dfs(new Dot(buf.i + 1, buf.j, 2));
			}
			if (buf.i + 1 >= 0 && buf.j + 1 >= 0 && buf.i + 1 < N && buf.j + 1 < N && map[buf.i + 1][buf.j + 1] == 0
					&& map[buf.i + 1][buf.j] == 0 && map[buf.i][buf.j + 1] == 0) {
				
					dfs(new Dot(buf.i + 1, buf.j + 1, 3));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(new Dot(0, 1, 1));

		System.out.println(result);

	}

}
