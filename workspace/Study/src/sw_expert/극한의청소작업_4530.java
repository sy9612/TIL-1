package sw_expert;

import java.util.Scanner;

public class 극한의청소작업_4530 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			long A = sc.nextLong();
			long B = sc.nextLong();
			
			long result = B-A;
			
			String st = Long.toString(result);
			
			long dp[] = new long [st.length()+1];
			
			dp[0] = 1;
			dp[1] = 18;
			
			for(int i=2; i<dp.length; i++) {
				dp[i] = (long) (dp[i-1]*9 +  9*Math.pow(10,i-1));
			}
			
			if(A<0 && B>0) result--;
			
			result -= dp[st.length()-1];
			
			System.out.println(result);
		}
		
	}
}
