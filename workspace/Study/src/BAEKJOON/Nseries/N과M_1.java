package BAEKJOON.Nseries;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_1 {
	static boolean visited[];
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean [N+1];
		
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
			if(!visited[i]) {
				visited[i] = true;
				arr[idx] = i;
				perm(idx+1, arr);
				visited[i] = false;
			}
		}
		
		
	}

}
