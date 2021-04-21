package BAEKJOON;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ZOAC_16719 {

	private static String st;
	private static char[] ch;
	private static boolean[] check;
	private static PriorityQueue<String> result;
	private static PriorityQueue<Node> pqm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		st = sc.next();

		ch = new char[st.length()];

		char min = st.charAt(0);
		

		pqm = new PriorityQueue<>();
		pqm.add(new Node(st.charAt(0),0));
		check = new boolean[st.length()];
		for (int i = 1; i < st.length(); i++) {
			if (min > st.charAt(i)) {
				min = st.charAt(i);
			}
			pqm.add(new Node(st.charAt(i), i));
		}


		result = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		while(!pqm.isEmpty()) {
			Node m = pqm.poll();
			if(!check[m.idx])
				find(m.cur, m.idx);
			
		}
		
		while(!result.isEmpty()) {
			System.out.println(result.poll());
			
		}
	}

	

	static class Node implements Comparable<Node> {
		char cur;
		int idx;

		Node(char cur, int idx) {
			this.cur = cur;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {

			if (this.cur == o.cur) {
				return o.idx - this.idx;
			}

			return this.cur - o.cur;
		}

	}

	static void find(char cur, int idx) {

		ch[idx] = cur;
		check[idx] = true;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = idx + 1; i < st.length(); i++) {
			if (!check[i])
				pq.add(new Node(st.charAt(i), i));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != '\u0000') {
				sb.append(ch[i]);
			}
		}
		result.add(sb.toString());
		while (!pq.isEmpty()) {
			Node min = pq.poll();

			if (!check[min.idx]) {

				find(min.cur, min.idx);
			}

		}

	}
}
