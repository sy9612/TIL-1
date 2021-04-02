package 이것이코딩테스트다;

import java.util.PriorityQueue;

/**
 * 시간이 적게 걸리는 음식부터 제거 > 우선순위 큐
 * 
 * @author 15com
 *
 */
public class 무지의먹방라이브 {
	public static void main(String[] args) {
		int[] food_times = { 8, 6, 4 };
		long k = 15;

		solution(food_times, k);
	}

	static class Node implements Comparable<Node> {
		int time;
		int num;

		Node(int time, int num) {
			this.time = time;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {

			return this.time - o.time;
		}
	}

	public static int solution(int[] food_times, long k) {
		int answer = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < food_times.length; i++)
			pq.add(new Node(food_times[i], i + 1));

		while (true) {
			if( pq.size() * pq.peek().time <= k)
				break;
			Node now = pq.poll();
		}

		return answer;
	}
}
