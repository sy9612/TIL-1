package BAEKJOON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 달력_20207 {
	static class Node implements Comparable<Node>{
		int st;
		int end;
		int len;
		
		Node(int st, int end, int len){
			this.st = st;
			this.end = end;
			this.len = len;
		}


		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			
			if(this.st == o.st) {
				return o.len - this.len;
			}
			return this.st - o.st;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] mon = new boolean[N+1][366];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			pq.add(new Node(st, end, end - st + 1));
		}
		
		int index = 0;
		while(!pq.isEmpty()) {
			Node buf = pq.poll();
			for (int i = 1; i <= N; i++) {
				if(!mon[i][buf.st]) {
					for (int j = 0; j < buf.len; j++) {
						mon[i][buf.st+j] = true;
					}
					break;
				}
			}
		}
		
		
		int rmax = 0;
		int cnt = 0;
		int result = 0;
		boolean ok = false;
		for (int j = 1; j < 366; j++) {
			ok = false;
			for (int i = 1; i <= N; i++) {
				if(mon[i][j]) {
					rmax = Math.max(rmax, i);
					ok = true;
				}
			}
			if(ok) cnt++;
			else if(!ok) {
				result += cnt *rmax;
				cnt = 0;
				rmax = 0;
			}
		}
		// 365일에 있는 경우
		if(ok) {
			result += rmax * cnt;
		}
		
		System.out.println(result);
		
		
		
		
		System.out.println();
	}
}
