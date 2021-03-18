package 백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 까먹었던 문제.. 나중에 다시 풀어봐야 함
 * 
 * @author kimjaewook
 *
 */
public class 돌다리_12761 {
	private static int[] map;
	private static int M;
	private static int N;
	private static int B;
	private static int A;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[100001];

		Arrays.fill(map, 987654321);

		if (N == M) {
			System.out.println(0);
			return;
		}

		Queue<Node> q = new LinkedList<>();

		boolean check[] = new boolean[100001];

		q.add(new Node(N, 0));
		check[N] = true;

		while (!q.isEmpty()) {
			Node buf = q.poll();
			check[buf.cur] = true;

			if (buf.cur == M) {
				System.out.println(buf.cnt);
				break;
			}

			if (buf.cur - 1 >= 0 && !check[buf.cur - 1]) {
				q.add(new Node(buf.cur - 1, buf.cnt + 1));
			}
			if (buf.cur - A >= 0 && !check[buf.cur - A]) {
				q.add(new Node(buf.cur - A, buf.cnt + 1));
			}
			if (buf.cur - B >= 0 && !check[buf.cur - B]) {
				q.add(new Node(buf.cur - B, buf.cnt + 1));
			}
			if (buf.cur + 1 <= 100000 && !check[buf.cur + 1]) {
				q.add(new Node(buf.cur + 1, buf.cnt + 1));
			}
			if (buf.cur + A <= 100000 && !check[buf.cur + A]) {
				q.add(new Node(buf.cur + A, buf.cnt + 1));
			}
			if (buf.cur + B <= 100000 && !check[buf.cur + B]) {
				q.add(new Node(buf.cur + B, buf.cnt + 1));
			}
			if (M > buf.cur && buf.cur * A <= 100000 && !check[buf.cur * A]) {
				q.add(new Node(buf.cur * A, buf.cnt + 1));
			}
			if (M > buf.cur && buf.cur * B <= 100000 && !check[buf.cur * B]) {
				q.add(new Node(buf.cur * B, buf.cnt + 1));
			}

		}

	}

}
