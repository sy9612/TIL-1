package baekjoon._0203;

import java.util.Arrays;
import java.util.Scanner;

public class 요세푸스순열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] q = new int[N];

		for (int i = 1; i <= N; i++) {
			q[i - 1] = i;
		}

		int result[] = new int[N];

		for (int cnt = 0; cnt < N;) {
			
		}

		System.out.println(Arrays.toString(result));

	}

}
