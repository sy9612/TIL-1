package LineTest;

import java.util.*;

public class _5 {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[][] = new String[5][4];
		String b[] = new String[3];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = sc.next();
			}
		}

		for (int i = 0; i < 3; i++) {
			b[i] = sc.next();
		}
		String[] c= solution(a, b);
		for(int i=0; i<c.length; i++)
			System.out.println(c[i]);
	}

	static class Node implements Comparable<Node> {
		String name;
		int cnt;

		Node(String i, int j) {
			this.name = i;
			this.cnt = j;
		};

		@Override
		public int compareTo(Node target) {
			if (this.cnt > target.cnt) {
				return -1;
			} else if (this.cnt == target.cnt) {
				return this.name.compareTo(target.name);
			}
			return 1;
		}

	}

	public static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer;
		PriorityQueue<Node> q = new PriorityQueue<>();

		HashSet<String> tag = new HashSet<>();
		for (int i = 0; i < tags.length; i++) {
			tag.add(tags[i]);
		}

		for (int i = 0; i < dataSource.length; i++) {
			int cnt = 0;
			for (int j = 1; j < dataSource[i].length; j++) {
				if (tag.contains(dataSource[i][j])) {
					cnt++;
				}
			}
			if (cnt != 0) {
				q.offer(new Node(dataSource[i][0], cnt));
			}
		}

		answer = new String[q.size()];
		for (int i = 0; i < answer.length; i++) {
			if (q.isEmpty())
				break;
			answer[i] = q.poll().name;
		}

		return answer;
	}
}
