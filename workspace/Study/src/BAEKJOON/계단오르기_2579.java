package BAEKJOON;

import java.util.Scanner;

public class 계단오르기_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int stairs[] = new int[N+1];

		for (int i = 0; i < N; i++) {
			stairs[i] = sc.nextInt();
		}


		int dp[] = new int[N+1];
		if (N > 0)
			dp[0] = stairs[0];
		if (N >= 1)
			dp[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
		if (N >= 2)
			dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
		}
		
		if(N == 0)
			System.out.println(0);
		else if(N== 1)
			System.out.println(stairs[0]);
		
		else System.out.println(dp[N - 1]);
	}
}
