package BAEKJOON;

import java.util.Scanner;

public class 가장긴바이토닉부분수열_11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int[] du = new int[N];
		int[] dd = new int[N];
		
		int result = 0;

		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && max < du[j]) {
					max = du[j];
				}
			}
			du[i] = max + 1;
		}
		
		for (int i = N-1; i >= 0; i--) {
			int max = 0;
			for (int j = N-1; j > i; j--) {
				if (arr[j] < arr[i] && max < dd[j]) {
					max = dd[j];
				}
			}
			dd[i] = max + 1;
		}
		
		for(int i=0; i<N; i++) {
			if(result < (du[i]+dd[i])) {
				result = du[i]+dd[i];
			}
		}
		
		
		System.out.println(result-1);
	}
}
