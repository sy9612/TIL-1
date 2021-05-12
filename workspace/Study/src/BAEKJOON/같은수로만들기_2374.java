package BAEKJOON;

import java.util.Scanner;

public class 같은수로만들기_2374 {
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();

		arr = new int[N + 1];
		int max = 0;
		int idx = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();

			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		int left = idx;
		int right = idx;
		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] == max)
				right = i;
			else
				break;
		}

		add(1, left, max);
		add(right + 1, N + 1, max);
		System.out.println(result);
	}

	static int result = 0;

	private static void add(int st, int end, int M) {

		if(st >= end) return;
		
		int max = 0;
		int left = 0;
		int right = 0;
		
		for (int i = st; i < end; i++) {
			if (arr[i] > max) {
				left = i;
				right = i;
				max = arr[i];
			} else if (arr[i] == max) {
				right = i;
			}
		}
	
		
		add(st, left, max);
		add(right + 1, end, max);
		
		result += M - max;
		for (int i = st; i < end; i++) {
			arr[i] = M;
		}
		return;

	}

}
