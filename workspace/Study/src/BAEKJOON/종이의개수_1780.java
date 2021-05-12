package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 종이의개수_1780 {
	private static int[][] arr;
	static int[] rs = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		paper(0, 0, N);
		for(int a : rs) {
			System.out.println(a);
		}
	}

	private static void paper(int r, int c, int N) {
		// TODO Auto-generated method stub
		
		
		int num = arr[r][c];

		if (N == 1) {
			rs[num + 1]++;
			return;
		}
//		System.out.println(N + " " + Arrays.toString(r) + " " + Arrays.toString(c));

		boolean ok = false;

		for (int i = r; i < r+N; i++) {
			for (int j = c; j < c + N; j++) {
				if (arr[i][j] != num) {
					ok = true;
					break;
				}
			}
			if (ok)
				break;
		}

		if (!ok) {
			rs[num + 1]++;
			return;
		}
		

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				paper(r + (N/3)*i, c + (N/3)*j, N/3);
			}
		}

	}
}
