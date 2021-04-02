package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class 냉장고_1828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int minon[][] = new int[N][2];

		// int maxon[] = new int[N];

		for (int i = 0; i < N; i++) {
			minon[i][0] = sc.nextInt();
			minon[i][1] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (minon[i][0] > minon[j][0]) {
					int temp = minon[i][0];
					minon[i][0] = minon[j][0];
					minon[j][0] = temp;

					temp = minon[i][1];
					minon[i][1] = minon[j][1];
					minon[j][1] = temp;
				}
			}
		}

		int ref[][] = new int[N][2];

		int refc = 0;
		ref[0][0] = minon[0][0];
		ref[0][1] = minon[0][1];
		for (int i = 1; i < N; i++) {

			int sign = 0;
			for (int j = 0; j < refc + 1; j++) {
				if (minon[i][0] <= ref[j][0] && minon[i][1] >= ref[j][1]) {
					sign = 0;
					break;
				}
				if (minon[i][0] > ref[j][1] || minon[i][1] < ref[j][0])
					sign = 1;
				else {
					sign = 0;
					ref[j][0] = Math.max(minon[i][0], ref[j][0]);
					ref[j][1] = Math.min(ref[j][1], minon[i][1]);
					break;

				}
			}
			if (sign == 1) {
				refc++;
				ref[refc][0] = minon[i][0];
				ref[refc][1] = minon[i][1];
			}
		}
		System.out.println(refc + 1);
	}
}
