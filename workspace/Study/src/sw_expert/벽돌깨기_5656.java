package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

//중복 순열을 이용해 완탐
//swap해서 교환
public class 벽돌깨기_5656 {
	/*
	 * 1. 중복순열을 이용해 구슬의 위치 결정 2. 위치가 결정되면 설명대로 Simulation 3. 남은 벽돌의 최소값을 찾음
	 * 
	 * 최적화: 중간에 더 이상 구슬을 안 던져도 되는 경우 -> 벽돌이 모두 깨졌을 경우
	 */
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[] perm;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();

			map = new int[H][W];
			perm = new int[N];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			permutation(0);

			for (int c = 0; c < N; c++) {

				for (int r = 0; r < H; r++) {
					if (map[r][c] != 0) {

						for (int d = 0; d < 4; d++) {
							
						}
						
					}
				}

			}
		}
	}

	private static void permutation(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(perm));
			return;
		}

		for (int i = 0; i < W; i++) {
			perm[idx] = i;
			permutation(idx + 1);
		}
	}
}
