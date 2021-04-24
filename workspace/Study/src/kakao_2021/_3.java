package kakao_2021;

import java.util.Arrays;

public class _3 {
	public static void main(String[] args) {

//		int n = 6;
//		int pas[] = { 1, 1, 1, 1, 1, 1 };
//		int train[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 6 } };

//		int n = 4;
//		int pas[] = { 2, 1, 2, 2 };
//		int train[][] = { { 1, 2 }, { 1, 3 }, { 2, 4 } };

		int n = 5;
		int pas[] = { 1, 1, 2, 1, 1 };
		int train[][] = { { 1,2 }, { 2, 3 }, { 1, 4 }, {1, 5} };

		
		System.out.println(Arrays.toString(solution(n, pas, train)));
	}

	public static int[] solution(int n, int[] passenger, int[][] train) {
		int[] answer = new int[2];

		map = new int[n + 1][n + 1];

		for (int i = 0; i < train.length; i++) {
			map[train[i][0]][train[i][1]] = 1;
			map[train[i][1]][train[i][0]] = 1;
		}

		max = 0;
		rs = 0;
		check = new boolean[n + 1];
		dfs(1, passenger[0], passenger);

		answer[0] = rs;
		answer[1] = max;

		return answer;
	}

	static boolean[] check;
	static int[][] map;
	static int max;
	static int rs;

	private static void dfs(int d, int sum, int[] pass) {

		check[d] = true;

		if (max < sum) {
			max = sum;
			rs = d;
		} else if (max == sum && rs < d) {
			rs = d;
		}

		for (int i = 1; i < map.length; i++) {
			if (map[d][i] == 1 && !check[i]) {
				dfs(i, sum + pass[i - 1], pass);
			}
		}

	}
}
