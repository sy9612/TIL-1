package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 오아시스재결합_3015 {
	static class Node {
		int t;
		int ol;

		Node(int t, int ol) {
			this.t = t;
			this.ol = ol;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		LinkedList<Node> q = new LinkedList<>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			int cnt = 1;

			while (!q.isEmpty()) {
				if (q.peekLast().t > x) {
					result++;
					break;
				} else if (q.peekLast().t < x) {
					result += q.pollLast().ol;
					cnt = 1;
				}
				// 같을 때
				else {
					result += q.peekLast().ol;
					cnt = q.pollLast().ol + 1;
				}
			}
			q.add(new Node(x, cnt));

		}

		System.out.println(result);

	}
}
