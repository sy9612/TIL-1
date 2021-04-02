//package baekjoon._0211;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class DFS와BFS_인접리스트 {
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		S = sc.nextInt();
//		adj = new LinkedList[N+1];
//		for(int i = 1; i <= N; i++)
//			adj[i] = new LinkedList<>();
//		for(int i = 0; i < M; i++) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			adj[a].add(b);
//			adj[b].add(a);
//		}
//		for(int i = 1; i <= N; i++)
//			Collections.sort(adj[i]);
//		visited = new boolean[N+1];
//		dfs(S);
//		System.out.println();
//		Queue<Integer> queue = new LinkedList<>();
//		visited = new boolean[N+1];
//		queue.add(S);
//		visited[S] = true;
//		while( !queue.isEmpty() ) {
//			int node = queue.poll();
//			System.out.print(node + " ");
//			for(int i = 1; i < adj[node].size(); i++) {
//				if( !visited[(int) adj[node].get(i)] ) {
//					visited[(int) adj[node].get(i)] = true;
//					queue.addAll(adj[node].get(i));
//				}
//			}
//		}
//	}
//	static boolean[] visited;
//	static int N, M, S;
//	static LinkedList[] adj;
//	static void dfs(Object object) {
//		System.out.print(object + " ");
//		visited[object] = true;
//		for(int i = 1; i < adj[object].size(); i++) {
//			if( !visited[(int) adj[object].get(i)] ) {
//				visited[(int) adj[object].get(i)] = true;
//				dfs(adj[object].get(i));
//			}
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
