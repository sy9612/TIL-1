package BAEKJOON;

import java.util.*;

public class 시리얼번호_1431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub

				if (o1.length() == o2.length()) {
					int len1 = 0;
					int len2 = 0;
					for (int i = 0; i < o1.length(); i++) {
						if (o1.charAt(i) <= '9' && o1.charAt(i) >= '1') {
							len1 += o1.charAt(i) - '0';
						}
					}
					for (int i = 0; i < o2.length(); i++) {
						if (o2.charAt(i) <= '9' && o2.charAt(i) >= '1') {
							len2 += o2.charAt(i) - '0';
						}
					}

					if (len1 == len2) {
						 return o1.compareTo(o2);
					}

					return len1 < len2 ? -1 : 1;
				}

				return o1.length() - o2.length();
			}

		});

		
		for (int i = 0; i < N; i++) {
			pq.add(sc.next());
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
