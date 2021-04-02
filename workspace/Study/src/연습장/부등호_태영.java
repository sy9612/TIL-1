package 연습장;

import java.util.Arrays;
import java.util.Scanner;

public class 부등호_태영 {
	boolean[] number = new boolean[10];
	static boolean[] visit = new boolean[10];
	static int n = 0;
	static String min = "9876543210";
	static long max = 0;
	static int[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.next().charAt(0);
		}
		// < 60 > 62
		int[] result = new int[n + 1]; // 결과 담는 함수
		pe(0, result); // 재귀
		StringBuilder sbMax = new StringBuilder();
		StringBuilder sbMin = new StringBuilder();
		sbMax.append(max);
		sbMin.append(min);

		while (sbMax.length() != n + 1) {
			sbMax.insert(0, 0);
		}
		while (sbMin.length() != n + 1) {
			sbMin.insert(0, 0);
		}
		System.out.println(sbMax);
		System.out.println(sbMin);

	}

	private static void pe(int idx, int[] result) {
		// idx가 result의 끝을 가리킬 때
		if (idx == n + 1) {
			int flag = 0;

			for (int j = 0; j < result.length - 1; j++) {
				if (arr[j] == 60 && result[j] < result[j + 1]) {
					flag++;
				} else if (arr[j] == 62 && result[j] > result[j + 1]) {
					flag++;
				}
			}
			// System.out.println(min);

			if (flag + 1 != idx) {
				return;
			}

			long sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i] * (Math.pow(10, result.length - 1 - i));
			}

			max = Math.max(sum, max);
			long l = Long.parseLong(min);
			min = "" + Math.min(l, sum);

			return;
		}

		if (idx > n + 1) {
			return;
		}

		// 순열
		// 순열로 모든 경우의 수를 만듦
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				result[idx] = i;
				visit[i] = true;
				pe(idx + 1, result);
				visit[i] = false;
			}
		}

	}
}
