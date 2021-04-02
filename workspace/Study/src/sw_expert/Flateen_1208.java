package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class Flateen_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			System.out.print("#" + tc + " ");
			int dump[] = new int[100];

			for (int i = 0; i < 100; i++) {
				dump[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				Arrays.sort(dump);
				dump[99]--;
				dump[0]++;
			}
			Arrays.sort(dump);
			System.out.println(dump[99]-dump[0]);

		}

	}

	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
		}
		System.out.println();
	}

}
