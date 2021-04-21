package BAEKJOON;

import java.util.Scanner;

public class 배열돌리기_17276 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 입력
		int T = sc.nextInt();

		/**
		 * N = 배열의 크기 D = 각도
		 */
		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			int D = sc.nextInt();
			int[][] map = new int[N][N];

			
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 45도로 D가 정확하게 나누어 떨어지므로, 횟수를 줄여준다.
			D /= 45;

			// D가 0보다 작으면 역방향이므로, 정방향으로 바꿔준다.
			if (D < 0)
				D = 8 + D;

			// 8이면 360도 이므로 회전하지 않는다.
			if (D == 8) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				continue;
			}

			// 사방탐색 방법 진행
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			for (int cnt = 0; cnt < D; cnt++) {

				for (int d = 0; d < N / 2; d++) {

					int sp = map[d][d];
					int x = d;
					int y = d;
					int index = 0;

					while (index < 4) {
						
						// 중심에서 떨어진만큼 cr, cc 값이 더해짐
						int cr = x + dr[index] * (N / 2 - d);
						int cc = y + dc[index] * (N / 2 - d);

						if (cr < d || cc < d | cr >= N - d || cc >= N - d) {
							index++;
							continue;
						}

						map[x][y] = map[cr][cc];
						x = cr;
						y = cc;

					}
					map[d][d + (N / 2 - d)] = sp;
				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
