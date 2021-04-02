package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NQueen_9663 {

	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N + 1][N + 1];
		Queen(0, 0);
		System.out.println(result);
	}


	static int result = 0;
	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, -1, 1, 1, -1 };

	private static void Queen(int x, int y) {

		if (x >= N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			//놓을 수 있는 자리를 검사
			if (check(x, i)) {
				map[x][i] = 1;
				Queen(x + 1, i);
				map[x][i] = 0;
			}
		}

	}

	//시간초과
	private static boolean check(int x, int y) {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 8; j++) {
				int r = x + dr[j] * i;
				int c = y + dc[j] * i;

				if (r < 0 || c < 0 || r >= N || c >= N)
					continue;

				if (map[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}

}
