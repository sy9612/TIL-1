import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 회장뽑기_2660_플로이드와샬 {
	private static int N;
	private static int[][] board;
	private static boolean[] check;
	private static int[][] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		board = new int[N + 1][N + 1];
		d = new int[N + 1][N + 1];
		

		for (int i = 0; i <= N; i++) {
			Arrays.fill(board[i], 987654321); //최대값으로 채워줌
		}
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 || b == -1)
				break;

			board[a][b] = 1;
			board[b][a] = 1;
		} //입력 동일

		//중간값
		for (int k = 1; k <= N; k++) {
			//시작값
			for (int i = 1; i <= N; i++) {
				//끝값
				for (int j = 1; j <= N; j++) {

					//i에서 k를 들리고 j까지 가는 길이가 i에서 j로 바로 가는 길이보다 작을 때, i에서 j까지 가는 길이는 i-> k -> j로 가는 최소값이 된다.
					if (board[i][j] > board[i][k] + board[k][j])
							board[i][j] = board[i][k] + board[k][j];
				}
			}
		}


		//score
		int min = Integer.MAX_VALUE;
		int[] score = new int[N + 1];
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int s = 0;
			for (int j = 1; j <= N; j++) {
				s = Math.max(s, board[i][j]);
			}
			result[i] = s;
			min = Math.min(min, s);
		}

		int cnt = 0;
		ArrayList<Integer> rs = new ArrayList<>();
		for (int i = 1; i < score.length; i++) {
			if (min == result[i]) {
				cnt++;
				rs.add(i);
			}
		}

		System.out.println(min + " " + cnt);
		for (int i = 0; i < rs.size(); i++) {
			System.out.print(rs.get(i) + " ");
		}
	}
}
