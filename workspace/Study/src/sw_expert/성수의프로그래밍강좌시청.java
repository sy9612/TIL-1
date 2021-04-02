package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 성수의프로그래밍강좌시청 {
	static int N, K;
	static double[] M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			 N = sc.nextInt();
			 K = sc.nextInt();
			 M = new double[N];
			
			for(int i=0; i<N; i++) {
				M[i] = sc.nextInt();
			}
			
			Arrays.sort(M);
			double result = 0;
			for(int i=N-K; i<N; i++) {
				result = (result+M[i])/2;
			}
			String str = String.format("%.6f", result);
			System.out.println(result);
		}
	}
}
