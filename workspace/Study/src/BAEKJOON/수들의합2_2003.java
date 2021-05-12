package BAEKJOON;

import java.util.Scanner;

/**
 * 두가지 방법
 * 1. 투포인터 --> 양수일때만 가능
 * 2. 해쉬
 * 	r > l 이고 prefix[r] - prefix[l] == M인 경우, A[l+1] .. A[r]의 합은 M이됨
 * 	hash에 답을 담아서 저장
 */
public class 수들의합2_2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] sum = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1]+sc.nextInt();
		}
		
		
		int rs = 0;
		for (int i = N; i >= 1 ; i--) {
			for (int j = 1; j <= i; j++) {
				if(sum[i] - sum[j-1] == M) {
					rs++;
				}
			}
		}
		System.out.println(rs);
		
	}
}
