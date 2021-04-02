package kakao_2020;

import java.util.Arrays;

public class _4 {
	public static void main(String[] args) {

		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares =
				// {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

				{ { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 }, { 2, 4, 66 },
						{ 2, 3, 22 }, { 1, 6, 25 } };
		int answer = solution(n, s, a, b, fares);
		System.out.println(answer);
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		int[][] map = new int[n + 1][n + 1];
		
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}

		for (int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] = fares[i][2];
			map[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		for (int i = 0; i < map.length; i++) { // 경유 정점
			for (int j = 0; j < map.length; j++) { // 출발 정점
				if (i == j)
					continue;
				for (int j2 = 0; j2 < map.length; j2++) { // 도착 정점
					if (j == j2 || i == j2)
						continue;
					if (map[j][i] != Integer.MAX_VALUE && map[i][j2] != Integer.MAX_VALUE && map[j][j2] > map[j][i] + map[i][j2])
						map[j][j2] = map[j][i] + map[i][j2];
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		answer += map[s][a] + map[s][b];

		return answer;
	}
}
