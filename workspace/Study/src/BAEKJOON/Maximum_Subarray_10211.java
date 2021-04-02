package BAEKJOON;

import java.util.Iterator;
import java.util.Scanner;

public class Maximum_Subarray_10211 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] sum = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				sum[i] = sum[i-1] + sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = N; i >= 1 ; i--) {
				for (int j = 1; j <= i; j++) {
					max = Math.max(sum[i] - sum[j-1], max);
				}
			}
			
			System.out.println(max);
			
			
		}
		
	}
}
