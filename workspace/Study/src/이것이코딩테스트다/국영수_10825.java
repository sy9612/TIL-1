package 이것이코딩테스트다;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 국영수_10825 {
	static class Node implements Comparable<Node>{
		String name;
		int korea;
		int eng;
		int math;
		
		Node(String name, int korea, int eng, int math){
			this.name = name;
			this.korea = korea;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Node o) {
			if(this.korea == o.korea) {
				if(this.eng == o.eng) {
					if(this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					else return o.math - this.math;
				}
				else return this.eng - o.eng;
			}
			else return o.korea - this.korea;
		}

	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(new Node(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().name);
		}
		
		
		
	}
}
