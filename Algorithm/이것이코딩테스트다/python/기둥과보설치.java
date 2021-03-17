package python;

import java.util.Scanner;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60061
 * 
 * @author 15com
 *
 */
public class 기둥과보설치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };

		solution(n, build_frame);

	}

	/**
	 * 
	 * @param n
	 * @param build_frame build_frame[x,y,a,b] x, y: 교차점 a : 0 기둥, 1 보 b : 0 삭제, 1
	 *                    설치
	 * @return
	 */
	public static int[][] solution(int n, int[][] build_frame) {
		int[][] answer = new int[build_frame.length][3];
		int cnt = 0;

		int[][] map = new int[n][n];

		for (int i = 0; i < build_frame.length; i++) {
			// 삭제
			if (build_frame[i][3] == 0) {
				cnt--;
				if (!possible(answer, cnt))
					cnt++;
			}
			// 설치
			else {
				answer[cnt][0] = build_frame[i][0];
				answer[cnt][1] = build_frame[i][1];
				answer[cnt][2] = build_frame[i][2];
				cnt++;
				if (!possible(answer, cnt))
					cnt--;

			}
		}

		return answer;
	}

	private static boolean possible(int[][] answer, int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (answer[i][2] == 0) {
				if (answer[i][1] == 0)
					continue;
				for (int j = 0; j < cnt; j++) {
					if (answer[j][0] == answer[i][0] - 1 && answer[j][1] == answer[i][1] && answer[j][2] == 1)
						continue;
					if (answer[j][0] == answer[i][0] && answer[j][1] == answer[i][1] && answer[j][2] == 1)
						continue;
					if (answer[j][0] == answer[i][0] && answer[j][1] - 1 == answer[i][1] && answer[j][2] == 1)
						continue;
					return false;
				}
			} else {
				for (int j = 0; j < cnt; j++) {
					if (answer[j][0] == answer[i][0] && answer[j][1] -1 == answer[i][1] && answer[j][2] == 0)
						continue;
					if (answer[j][0] == answer[i][0]+1 && answer[j][1]-1 == answer[i][1] && answer[j][2] == 0)
						continue;
					if (answer[j][0] == answer[i][0]-1 && answer[j][1] == answer[i][1] && answer[j][2] == 1)
						continue;
					if (answer[j][0] == answer[i][0]+1 && answer[j][1] == answer[i][1] && answer[j][2] == 1)
						continue;
					return false;
				}

			}
		}
		return true;
	}
}
