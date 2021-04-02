package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 강의실배정_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int max = 0;
		
		String[][] x = new String[N][2];
		for (int i = 0; i < N; i++) {
			x[i] = br.readLine().split(" ");
		}
		
		Arrays.sort(x, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
					return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
				}
				
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
			
		});
		
		
		
		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty()) {
				if (pq.peek() <= Integer.parseInt(x[i][0]))
					pq.poll();
				else
					break;
			}

			pq.add(Integer.parseInt(x[i][1]));

			max = Math.max(pq.size(), max);
		}

		System.out.println(max);
	}
}
