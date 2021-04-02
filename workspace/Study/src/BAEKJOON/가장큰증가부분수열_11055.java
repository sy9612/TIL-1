package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class 가장큰증가부분수열_11055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int[] d = new int[N];

		d[0] = arr[0];
		int result = 0;

		for (int i = 0; i < N; i++) {

			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && max < d[j]) {
					max = d[j];
				}
			}
			d[i] = max + arr[i];
			if (result < d[i])
				result = d[i];
		}
		
		System.out.println(result);
	}
}
