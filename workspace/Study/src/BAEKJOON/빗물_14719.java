package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 빗물_14719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			for (int j = 0; j < a; j++) {
				map[N - 1 - j][i] = 1;
			}
		}

		int result = 0;
		int ch = 2;
		for (int i = 0; i < N; i++) {
//			for (int ii = 0; ii < map.length; ii++) {
//				System.out.println(Arrays.toString(map[ii]));
//			}
//			
			int cnt = 0;
			for (int j = 1; j < M; j++) {
				int dy = j;
				if (map[i][j] == 0 && map[i][j - 1] == 1) {
					map[i][j] = ch;
					dy = j + 1;
					cnt++;
					while (true) {

						if (dy >= M) {
							cnt = 0;
							break;
						} else if (map[i][dy] == 0) {
							map[i][dy] = ch;
							dy++;
							cnt++;
						} else if (map[i][dy] == 1) {
							break;
						}
					}
				}
				j = dy;
				result += cnt;

				if (cnt != 0) {
					ch++;
				}
				cnt = 0;
			}

		}
		System.out.println(result);


	}
}
