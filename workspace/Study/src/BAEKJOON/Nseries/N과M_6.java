package BAEKJOON.Nseries;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_6 {
	static int N;
	static int M;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		result = new int[M];
		perm(0, arr,0);
		
	}

	private static void perm(int idx, int[] arr,int start) {
		if(idx == M) {
			for(int j=0; j<M; j++)
				System.out.print(result[j] + " ");
			System.out.println();
			return;
		}
		for(int i=start; i<N; i++) {
			result[idx] = arr[i];
			perm(idx+1, arr, i+1);
		}
	}
}
