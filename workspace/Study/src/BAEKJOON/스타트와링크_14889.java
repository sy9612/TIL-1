package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 스타트와링크_14889 {
	static int N;
	static int[][] S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		}

		int[] result = new int[N / 2];
		// 조합
		comb(result, 0, 0);
		
		System.out.println(min);

	}
	static int min = 1000;
	private static void comb(int[] result, int idx, int sidx) {
		if (sidx == result.length) {
			boolean[] visited = new boolean[N];

			for (int i = 0; i < result.length; i++)
				visited[result[i]] = true;

			int[] linker = new int[N / 2];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					linker[cnt++] = i;
				}
			}
			
			sum = 0;
			comb2(new int[2], result, 0, 0);
			int start = sum;
			
			sum = 0;
			comb2(new int[2], linker, 0, 0);
			int link = sum;
			
			if(min > Math.abs(start - link)) {
				min = Math.abs(start - link);
			}
						
			return;
		}
		if (idx == N)
			return;

		result[sidx] = idx;

		comb(result, idx + 1, sidx + 1);
		comb(result, idx + 1, sidx);

	}
	static int sum =0;
	private static void comb2(int[] arr, int[] a, int idx, int sidx) {
		if (sidx == arr.length) {
			
			sum += S[arr[0]][arr[1]];
			sum += S[arr[1]][arr[0]];
			
			return;
		}
		if(idx == a.length)
			return;
		
		
		arr[sidx] = a[idx];

		comb2(arr, a, idx + 1, sidx + 1);
		comb2(arr, a, idx + 1, sidx);
	}
}
