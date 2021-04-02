package baekjoon._0211;

import java.util.*;
//인접 행렬로 풀 수 없음
//인접 리스트
public class 효울적인_해킹_1325 {
	static boolean[] visited;
	static int N, M, cnt;
	static LinkedList<Integer>[] adj;
	static boolean check[];
	//정점의 개수만큼 링크드리스트가 필요함
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
//		S = sc.nextInt();
		adj = new LinkedList[N+1];
		for(int i=1 ;i<=N; i++) {
			adj[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			//adj[a].add(b);
			adj[b].add(a);
		}
		for(int i=1; i<= N; i++)
			Collections.sort(adj[i]);
		
		for(int i=1; i<=N; i++) {
			check = new boolean[N+1];
			cnt = 0;
			dfs(i);
			System.out.println(cnt);
		}	
//		LinkedList<Integer> q = new LinkedList<>();
//		q.add(1);
//		
//		boolean check[] = new boolean[N+1];
//		
//		while(!q.isEmpty()) {
//			int buf = q.poll();
//			for(int i=0; i<adj[buf].size(); i++) {
//				if(!check[adj[buf].get(i)]) {
//					q.add(adj[buf].get(i));
//					check[adj[buf].get(i)] = true;
//				}
//			}
//		}
	}
	private static void dfs(int v) {
		// TODO Auto-generated method stub
		check[v] = true;
		
		for(int i=0; i<adj[v].size(); i++) {
			if(!check[adj[v].get(i)]) {
				cnt++;
				dfs(i);
			}
		}
	}

}
