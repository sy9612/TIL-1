package BAEKJOON;

import java.util.Scanner;

public class 두배열의합_2143 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int B[] = new int[N];
		
		for(int i=0; i<M; i++) {
			B[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		for(int i=1; i< (1<<N); i++) {
			for(int j=0; j<N; j++) {
				if( (i & (1<<j)) != 0) {
					System.out.print(A[j]);
				}
			}
			System.out.println();
		}
		System.out.println("--");
		for(int i=1; i< (1<<M); i++) {
			for(int j=0; j< M; j++) {
				if( (i& (1<<j)) != 0) {
					System.out.print(B[j]);
				}
			}
			System.out.println();
		}
	}
}
