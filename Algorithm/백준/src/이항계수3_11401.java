import java.util.Scanner;

/**
 * 이항계수
 * 모름
 * @author 15com
 *
 */
public class 이항계수3_11401 {
	static int[][] dp;
	
	static int binomial(int n, int r) {
		if(r == 0 || n == r) 
			return 1;
		if(dp[n][r] == 0) 
			dp[n][r] = binomial(n - 1, r - 1) + binomial(n - 1, r);
		return dp[n][r];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
	}
}
