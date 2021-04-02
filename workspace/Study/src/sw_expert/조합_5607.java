package sw_expert;

import java.util.Scanner;

public class 조합_5607 {
	
	static long factorial[], inverse[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			factorial = new long[N+1];
			inverse = new long[N+1];
			// N! / R!(N-R)!
			
			// N! 구하기
			factorial[1] = 1;
			for(int i=2; i<=N; i++) {
				factorial[i] = (i * factorial[i-1])%1234567891;
			}
			
			//factorial의 inverse 구하기
			//페르마의 소정리에 따라 a^(p-2) = 1/a이므로
			//factorial[N]에 123456789-2를 해주면 inverse 값을 얻을 수 있음
			inverse[N] = (long) Math.pow(factorial[N], 1234567891-2); // 1234567891 - 2
			inverse[N-R] = (long) Math.pow(factorial[N-R], 1234567891-2);
			inverse[R] = (long) Math.pow(factorial[R], 1234567891-2);
			
			long result = (factorial[N] * inverse[N-R])%1234567891;
			result = (result * inverse[R]) % 1234567891;
			System.out.println(result);
			
		}
	}
}
