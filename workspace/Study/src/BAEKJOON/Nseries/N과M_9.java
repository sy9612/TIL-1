package BAEKJOON.Nseries;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_9 {
	static int N;
	static int M;
	static int[] result;
	static boolean[] check = new boolean[10000000];
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		Arrays.sort(arr);
		result = new int[M];
		visited = new boolean[N+1];
		perm(0, arr);
	}

	private static void perm(int idx, int[] arr) {
		if (idx == M) {
			int buf = 0;
			for (int i = 0; i < result.length; i++) {
				buf += result[i] * (Math.pow(10, result.length - 1 - i));
			}
			if (check[buf] == false) {
				for (int j = 0; j < M; j++)
					System.out.print(result[j] + " ");
				System.out.println();
				check[buf] = true;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				perm(idx+1, arr);
				visited[i] = false;
			}
		}
	}
}
