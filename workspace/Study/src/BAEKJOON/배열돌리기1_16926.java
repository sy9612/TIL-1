package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 배열돌리기1_16926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배열의 세로
		int M = sc.nextInt(); // 배열의 가로
		int R = sc.nextInt(); // 회전 횟수

		int[][] map = new int[N][M];

		// 배열 채우기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 우 하 좌 상 --> 반시계방향
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// R만큼 반복한다.
		for (int r = 0; r < R; r++) {

			// 가로, 세로 중 작은 것의 절반만큼 회전해야하는 사각형이 나온다.
			for (int cnt = 0; cnt < Math.min(N, M) / 2; cnt++) {

				// 첫 번째 숫자를 기억해야한다. save_point
				int sp = map[cnt][cnt];

				// 시작점
				int x = cnt;
				int y = cnt;

				// dr, dc의 index
				int i = 0;

				// 4 방향을 다 돌면 종료한다.
				while (i < 4) {

					// 반시계방향으로 배열이 회전하므로, (x, y)에 들어가야 할 위치를 찾음
					int cx = x + dr[i];
					int cy = y + dc[i];

					// 범위를 벗어나면 index를 증가시키고 덮어쓰기는 진행하지 않음
					if (cx < cnt || cy < cnt || cx >= N - cnt || cy >= M - cnt) {
						i++;
						continue;
					}

					// 값 저장
					map[x][y] = map[cx][cy];

					// (x, y)는 이동한 좌표가 된다.
					x = cx;
					y = cy;

				}
				
				// 제일 마지막에 시작 값을 넣어준다.
				map[cnt + 1][cnt] = sp;

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}

			System.out.println();
		}

	}
}
