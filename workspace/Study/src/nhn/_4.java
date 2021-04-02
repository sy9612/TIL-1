package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _4 {
	static class Node {
		int i;
		int j;
		int k;

		Node(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		};
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int G = Integer.parseInt(st[1]);
		int M = Integer.parseInt(st[2]);

		int[] S = new int[M];
		st = br.readLine().split(" ");
		int[] R = new int[M];
		for (int i = 0; i < M; i++) {
			S[i] = Integer.parseInt(st[i]);
		}
		st = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			R[i] = Integer.parseInt(st[i]);
		}

		int[] check = new int[N];

		for (int i = 0; i < M; i++) {
			check[S[i]] = R[i];
		}

		int result = Integer.MAX_VALUE;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, G));

		while (!q.isEmpty()) {
			Node buf = q.poll();

			if (buf.i >= N-1) {
				if (result > buf.j) {
					result = buf.j;
				}
			}
			if (buf.k >= 0) {
				for (int i = buf.i+1; i < N; i++) {
					if(i < check.length && check[i] != 0) {
						q.add(new Node(buf.i + i, buf.j + 1, buf.k + check[i] - i));
						q.add(new Node(buf.i + i, buf.j, buf.k - i));
						break;
					}

				}
			}
		}
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(result);

	}
}
