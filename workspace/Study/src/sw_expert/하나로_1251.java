package sw_expert;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로_1251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int island[][] = new int[N][2];
			
			for(int i=0; i<N ;i++) {
				island[i][0] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				island[i][1] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			long[][] graph = new long[N][N];
			int[] from, to;
			for(int r =0; r< N; r++) {
				from = island[r];
				for(int c = r+1; c<N; c++) {
					to = island[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0]-to[0]) * (from[1]-to[1]) * (from[1]-to[1]);
				}
			}
			
			//////////////prim algorithm/////////////
			
			long cost = 0;
			//MST에 들어가지 않은 것들
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			//모든 정점 관리
			Edge[] dynamicGraph = new Edge[N];
			
			int start = 0;
			
			for(int n=0; n<dynamicGraph.length; n++) {
				dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
				if(n==start) {
					dynamicGraph[n].cost = 0;
				}
				pq.add(dynamicGraph[n]);
			}
			
			
			while(!pq.isEmpty()) {
				Edge front = pq.poll(); // MST에 포함
				cost += front.cost;
				
				//자식 탐색
				for(int i=0; i<dynamicGraph.length; i++) {
					Edge child = dynamicGraph[i];
					// pq: 비 MST
					if(pq.contains(child)) {
						long tempCost = graph[front.idx][child.idx];
						if(tempCost < child.cost) {
							child.cost = tempCost;
							pq.remove(child);
							pq.offer(child); // 순서를 다시 바꿔주기 위해
						}
					}
				}
			}
			
			System.out.println(cost);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		
		public Edge(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		
		@Override
		public int compareTo(Edge o) {
			// o.cost - Long.MIN_VALUE
			// return this.cost - o.cost >0 ? 1 : -1;
			// 범위를 벗어나게 될 수 있음
			return Long.compare(this.cost, o.cost);
		}
		
		
	}
	
	

	static boolean visited[];
	// 환경부담금
	private static double ecomoney(double E, int X1, int Y1, int X2, int Y2) {
		double L = Math.abs(Math.pow(X1-X2, 2) - Math.pow(Y1-Y2, 2));
		return E*L;
	}
}
