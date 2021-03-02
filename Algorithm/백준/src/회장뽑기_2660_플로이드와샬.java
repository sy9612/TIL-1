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
			Arrays.fill(board[i], Integer.MAX_VALUE);
		}
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 | b == -1)
				break;

			board[a][b] = 1;
			board[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (board[i][j] > board[i][k] + board[k][j])
							board[i][j] = board[i][k] + board[k][j];
				}
			}
		}

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
