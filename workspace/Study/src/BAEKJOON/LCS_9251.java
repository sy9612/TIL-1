package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
<<<<<<< HEAD
		
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
				max = Math.max(dp[i][j], max);
			}
		}
		
=======

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

				max = Math.max(dp[i][j], max);
			}
		}

>>>>>>> f0b33d970cfd12ecae2a0ad1b8df29e60a2f88d0
		System.out.println(max);
	}
}
