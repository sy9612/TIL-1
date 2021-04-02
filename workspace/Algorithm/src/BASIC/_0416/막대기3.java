package BASIC._0416;

import java.util.Scanner;

public class 막대기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N+1];
		
		if(N >=1)
			dp[1] = 1;
		if( N>=2)
			dp[2] = 2;
		if(N>=3)
			dp[3] = 4;
		
		for(int i=4; i<=N; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[N]);
	}
}
	