package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

class dot5 {
	int i;
	int j;

	dot5(int i, int j) {
		this.i = i;
		this.j = j;
	};
}

public class 숨바꼭질_1697 {
	static int N;
	static int K;
	static int m = 100000;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		check = new boolean[100001];
		bfs(N, 0);

	}

	private static void bfs(int n, int result) {
		// TODO Auto-generated method stub
		dot5 a = new dot5(n, result);
		LinkedList<dot5> q = new LinkedList<>();

		q.add(a);
		check[a.i] = true;

		while (!q.isEmpty()) {
			dot5 qqqq = q.poll();
			int nn = qqqq.i;
			if (nn >= 100001|| nn < 0)
				continue;
			if (nn == K) {
				System.out.println(qqqq.j);
				return;
			}
			
			if ((nn-1)>=0 && check[nn - 1] == false) {
				check[nn-1] = true;
				dot5 buf3 = new dot5(nn - 1, qqqq.j + 1);
				q.add(buf3);
			}
			if (nn*2<100001 && check[nn * 2] == false) {
				check[2*nn] = true;
				dot5 buf = new dot5(2 * nn, qqqq.j + 1);
				q.add(buf);
			}
			if ((nn+1) <100001 && check[nn + 1] == false) {
				check[nn+1] = true;
				dot5 buf2 = new dot5(nn + 1, qqqq.j + 1);
				q.add(buf2);
			}

		}
	}

}
