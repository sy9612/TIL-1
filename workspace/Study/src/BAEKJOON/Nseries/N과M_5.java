package BAEKJOON.Nseries;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_5 {
	static int N;
	static int M;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		visited = new boolean [N+1];
		Arrays.sort(arr);
		
		int result[] = new int[M];
		perm(0, arr, result);

	}
	private static void perm(int idx, int[] arr,int[] result) {
		if(idx == M) {
			for(int j=0; j<result.length; j++)
				System.out.print(result[j] + " ");
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				perm(idx+1, arr, result);
				visited[i] = false;
			}
		}
		
	}

}
