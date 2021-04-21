package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Suffix_Array_9248 {
	static class Node implements Comparator<Node>{
		String subSt;
		int cnt;
		
		Node(String subSt, int cnt){
			this.subSt = subSt;
			this.cnt = cnt;
		}

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.subSt.compareTo(o2.subSt) == 0) {
				return o1.subSt.length() - o2.subSt.length();
			}
			return o1.subSt.compareTo(o2.subSt);
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < s.length(); i++) {
			String sb = s.substring(i, s.length());
			System.out.println(sb);
			pq.add(new Node(sb, i+1));
		}
		
		System.out.println();
		
	}
}
