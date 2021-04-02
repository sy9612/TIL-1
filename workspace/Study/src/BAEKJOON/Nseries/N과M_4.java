package BAEKJOON.Nseries;

import java.util.Scanner;

public class N과M_4 {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int arr[] = new int[M];
		perm(0, arr);
		
	}

	private static void perm(int idx, int[] arr) {
		if(idx == M) {
			for(int j=0; j<arr.length; j++)
				System.out.print(arr[j] + " ");
			System.out.println();
			return;
		}
		for(int i=1; i<N+1; i++) {
			if(idx != 0 && arr[idx-1] > i)
				continue;
			arr[idx] = i;
			perm(idx+1, arr);
		}
	}
}
