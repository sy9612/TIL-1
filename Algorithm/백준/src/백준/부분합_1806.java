package 백준;

import java.util.Scanner;

public class 부분합_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + sc.nextInt();
		}

		int rs = Integer.MAX_VALUE;
		for (int j = 0; j <= N; j++) {
			for (int i = N; i >= 1; i--) {
				if (i-j-1>= 0 && sum[i] - sum[i - j - 1] >= S) {
					rs = Math.min(j, rs);
					if (rs == Integer.MAX_VALUE)
						System.out.println(0);
					else
						System.out.println(rs+1);

					return;

				}
			}
		}

	}

}
