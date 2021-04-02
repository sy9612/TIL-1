package BASIC._0423;

import java.util.Scanner;

public class 소금배달_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		int[] memo = new int[M+1];
		
		// 첫 줄 setting
		for (int i = 0; i < memo.length; i++) {
			if(i%3 == 0)
				memo[i] = i/3;
			else {
				memo[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 5; i < memo.length; i++) {
			if(memo[i-5] != Integer.MAX_VALUE != memo[i] > memo[i-5]+1) {
				memo[i] =memo[i-5]+1;
			}
		}
		System.out.println(memo[M] == Integer.MAX_VALUE ? -1 : memo[M]);
	}
}
