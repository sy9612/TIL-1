package BAEKJOON;

import java.util.Scanner;

public class 수들의합2_2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] sum = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1]+sc.nextInt();
		}
		
		int rs = 0;
		for (int i = N; i >= 1 ; i--) {
			for (int j = 1; j <= i; j++) {
				if(sum[i] - sum[j-1] == M) {
					rs++;
				}
			}
		}
		System.out.println(rs);
		
	}
}
