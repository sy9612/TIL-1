package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 연속합2_13398 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum[][] = new int[N][2];
		int max = Integer.MIN_VALUE;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}


		sum[0][0] = arr[0];
		
		//모두 음수인경우
		sum[0][1] = arr[0];
		max = arr[0];
		
		for (int i = 1; i < N; i++) {
			
			// i번째부터 시작하는 경우와 이전 합까지 다 있는 경우
			sum[i][0] = Math.max(sum[i-1][0]+ arr[i], arr[i]);
			
			// 내가 없는 경우 or 이전게 없는 경우
			sum[i][1] = Math.max(sum[i-1][0], sum[i-1][1]+arr[i]);
			
			max = Math.max(max, sum[i][0]);
			max = Math.max(max, sum[i][1]);

		}
		

		System.out.println(max);

	}
}
