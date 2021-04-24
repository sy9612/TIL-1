package BAEKJOON;

import java.util.*;

public class 과제_13904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue[] day = new PriorityQueue[1001];

		for (int i = 0; i < day.length; i++) {
			day[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		for (int i = 0; i < N; i++) {
			int d = sc.nextInt();
			int w = sc.nextInt();
			day[d].add(w);
		}

		int sum = 0;

		for (int i = 1000; i > 0; i--) {

			int max = 0;
			int buf = 0;
			for (int j = i; j < 1001; j++) {
				if (!day[j].isEmpty() && max < (int) day[j].peek()) {
					max = (int) day[j].peek();
					buf = j;
				}
			}

			day[buf].poll();
			sum += max;
		}
		System.out.println(sum);
	}
}
