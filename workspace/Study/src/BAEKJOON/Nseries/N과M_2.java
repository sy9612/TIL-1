package BAEKJOON.Nseries;

import java.util.Scanner;

public class N과M_2 {
	static int arr[];
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int [M];
		
		int start = 1;
		int s_idx = 0;
		comb(start, s_idx);
	}

	private static void comb(int start, int s_idx) {
		if(s_idx == arr.length) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(start == N+1)
			return;
		
		arr[s_idx] = start;
		comb(start+1,s_idx+1);
		comb(start+1,s_idx);
		
	}

}
