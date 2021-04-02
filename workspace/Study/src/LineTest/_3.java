package LineTest;

import java.util.*;

public class _3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int n = sc.nextInt();
		System.out.println(solution(a, n));
	}

	static class Node {
		char buf;
		int n;
		int cnt;

		Node(char buf, int n, int cnt) {
			this.buf = buf;
			this.n = n;
			this.cnt = cnt;
		};
	}

	public static int solution(String road, int n) {
		int answer = -1;

		Queue<Node> q = new LinkedList<>();
		if (road.charAt(0) == '1') {
			q.add(new Node(road.charAt(0), n, 1));
		} else {
			if (n > 0)
				q.add(new Node(road.charAt(0), n - 1, 1));
			q.add(new Node(road.charAt(0), n, 0));
		}
		q.add(new Node(road.charAt(0), n, 0));
		int i = 1;
		while (!q.isEmpty()) {
			if (i > road.length())
				break;
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Node buf = q.poll();
				int cnt = buf.cnt;

				if (buf.buf == '1') {
					if (i != road.length())
						q.add(new Node(road.charAt(i), buf.n, buf.cnt + 1));
				} else {
					if (i != road.length()) {
						if (buf.n > 0)
							q.add(new Node(road.charAt(i), buf.n - 1, buf.cnt + 1));
						q.add(new Node(road.charAt(i), buf.n, 0));
					}
				}
				if (answer < cnt)
					answer = cnt;
			}
			i++;
		}

		return answer;
	}

}
