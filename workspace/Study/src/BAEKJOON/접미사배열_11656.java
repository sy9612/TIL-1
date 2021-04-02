package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 접미사배열_11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		pq.add(S);
		
		for (int i = 1; i < S.length(); i++) {
			pq.add(S.substring(i, S.length()));
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
