import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 회장뽑기_2660 {
	private static int N;
	private static int[][] board;
	private static boolean[] check;
	private static int[][] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		board = new int[N + 1][N + 1];
		d = new int[N + 1][N + 1];

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 | b == -1)
				break;

			board[a][b] = 1;
			board[b][a] = 1;
		}

		int[] result = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			check = new boolean[N + 1];
			dfs(i, i, 0);
			Arrays.sort(d[i]);
			result[i] =	d[i][d[i].length-1];
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < result.length; i++) {
			if(min > result[i])
				min = result[i];
		}
		int cnt = 0;
		ArrayList<Integer> rs = new ArrayList<>();
		for (int i = 1; i < result.length; i++) {
			if(min == result[i]) {
				cnt++;
				rs.add(i);
			}
		}
		System.out.println(min + " " + cnt);
		for (int i = 0; i < rs.size(); i++) {
			System.out.print(rs.get(i) +" ");
		}
		

	}

	private static void dfs(int idx, int st, int cnt) {

		d[st][idx] = cnt;
		check[idx] = true;

		for (int i = 1; i < N + 1; i++) {
			if (board[idx][i] == 1) {
				if (!check[i] || cnt + 1 < d[st][i]) {
					dfs(i, st, cnt + 1);
				}
			}
		}
	}

}
