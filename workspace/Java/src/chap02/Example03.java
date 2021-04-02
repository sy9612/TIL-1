package chap02;

import java.util.Arrays;

/* 문제
 * 지웅이랑 기영이랑 전쟁을 합니다. 기영이가 먼저 지웅이를 공격했습니다.
 * 선제 공격을 받은 지웅이는 반격을 하려고 합니다.
 * 그래서 새로운 미사일을 개발하였는데 이 미사일은 공격받은 지점을 중심으로 상하좌우대각선(8방)을 랜덤한 공격력으로 공격합니다.
 * 공격력은 2 ~ 5 사이의 값을 받습니다.
 * 
 * 지도는 10 * 10의 크기를 가지고 있습니다.
 * 공격은 총 10번의 횟수를 가지게 되며, 좌표는 1 ~ 10 사이의 r과  c 값을 갖습니다.
 * 
 * 이 때, 가장 중복되게 공격받은 지점의 횟수를 구하세요.
 */

public class Example03 {

	public static void main(String[] args) {
		int[][] map = new int[10][10];
		int[][] map_count = new int[10][10];
		
		int max = 0;
		int max_r = 0;
		int max_c = 0;
		
		for (int punch = 0; punch < 10; punch++) {
			int strong = (int) (Math.random() * 100) % 4 + 2;
			int r = (int) (Math.random() * 100) % 10;
			int c = (int) (Math.random() * 100) % 10;

			int[] dr = { 0, 0, 1, -1 };
			int[] dc = { 1, -1, 0, 0 };
			int[] dd_r = { 1, 1, -1, -1 };
			int[] dd_c = { 1, -1, -1, 1 };

			for (int i = 0; i < dr.length; i++) {
				for (int k = 1; k <= strong; k++) {

					int nr = r + dr[i] * k;
					int nc = c + dc[i] * k;

					int ndd_r = r + dd_r[i] * k;
					int ndd_c = c + dd_c[i] * k;

					if (nr >= 0 && nr < 10 && nc >= 0 && nc < 10) {
						map[nr][nc] = 1;
						map_count[nr][nc]++;
						if(max < map_count[nr][nc]) {
							max = map_count[nr][nc];
							max_r = nr;
							max_c = nc;
						}							
					}
					
					if(ndd_r >= 0 && ndd_r < 10 && ndd_c >= 0 && ndd_c < 10) {
						map[ndd_r][ndd_c] = 1;
						map_count[ndd_r][ndd_c]++;
						if(max<map_count[ndd_r][ndd_c]) {
							max = map_count[ndd_r][ndd_c];
							max_r = ndd_r;
							max_c = ndd_c;
						}
					}

				}
				
			}
			System.out.println("#" + punch);
			for (int j = 0; j < 10; j++) {
	 			System.out.println(Arrays.toString(map_count[j]));
			}
			System.out.println();
			}
		System.out.println("Max: " + max);
		System.out.println("위치: " + max_r +", " + max_c);
	}

}
