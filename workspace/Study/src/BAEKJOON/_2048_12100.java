package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class _2048_12100 {
	// 좌 우 하 상
	private static int[] dr = { 0, 0, -1, 1 };
	private static int[] dc = { -1, 1, 0, 0 };
	private static int N;
	private static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		move(0);
	}

	private static void move(int d) {
		// TODO Auto-generated method stub
		// 왼쪽 이동

		switch (d) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int r = i + dr[d];
					int c = j + dc[d];

					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[i][j] == map[r][c]) {
						map[r][c] *= 2;
						map[i][j] = 0;
					} else if (map[r][c] == 0) {
						map[r][c] = map[i][j];
						map[i][j] = 0;
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					int r = i + dr[d];
					int c = j + dc[d];

					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[i][j] == map[r][c]) {
						map[r][c] *= 2;
						map[i][j] = 0;
					} else if (map[r][c] == 0) {
						map[r][c] = map[i][j];
						map[i][j] = 0;
					}
				}
			}
			break;
		case 2:
			for (int j = 0; j < N; j++) {
				for (int i = N-1; i >= 0; i--) {
					int r = i + dr[d];
					int c = j + dc[d];

					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[i][j] == map[r][c]) {
						map[i][j] *= 2;
						map[r][c] = 0;
					} else if (map[i][j] == 0) {
						map[i][j] = map[r][c];
						map[r][c] = 0;
					}
				}
			}
			break;
		case 3:
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					int r = i + dr[d];
					int c = j + dc[d];

					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[i][j] == map[r][c]) {
						map[i][j] *= 2;
						map[r][c] = 0;
					} else if (map[i][j] == 0) {
						map[i][j] = map[r][c];
						map[r][c] = 0;
					}
				}
			}
			break;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}
}
