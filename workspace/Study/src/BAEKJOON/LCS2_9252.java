package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS2_9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		int lastx = -1, lasty = -1;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

				if (max < dp[i][j]) {
					max = Math.max(dp[i][j], max);
					lastx = i;
					lasty = j;
				}

			}
		}

		System.out.println(max);
//		
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		if (max != 0) {
			char[] arr = new char[max];
			int ll = max-1;
			int i = s1.length();
			int j = s2.length();
			
			for (int cnt = 0; cnt < arr.length;) {
				
				if(dp[i][j] == dp[i-1][j]) {
					i--;
				}
				else if(dp[i][j] == dp[i][j-1]) {
					j--;
				}
				else {
					arr[ll--] = s2.charAt(j-1);
					cnt++;
					i--; j--;
				}
			}
			
			for (int r = 0; r < arr.length; r++) {
				System.out.print(arr[r]);
			}
		}

	}
}
