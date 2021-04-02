package BASIC._0409;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		int[][] adj = new int[V][V]; // 인접 행렬
		int[] D = new int[V];
		for(int i=0; i<E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		//dijkstra 시작점이 a 정점이라면 D[a] = 0
		D[0] = 0;
		for(int i=0; i<V-1; i++) {
			int min = Integer.MAX_VALUE; // 가장 작은 값을 기억할 변수
			int index = -1; // 그 위치를 기억할 변수
			for(int j= 0; j<V; j++) {
				// 아직 처리하지 않았으면서, 가장 짧은 거리라면
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			if(index == -1) break;
			// 새로운 것으로 갈 수 있는 경로 업데이트
			for(int j=0; j<V; j++) {
				// 아직 처리하지 않았으면서, 경로가 존재하고, index까지의 거리 + index부터 j 까지의 거리가 D 보다 작다면
				if(!check[j] && adj[index][j] != 0 && D[index] + adj[index][j] < D[j])
					D[j] = D[index] + adj[index][j];
			}
			// 처리된 것으로 체크
			check[index] = true;
		}
		System.out.println(Arrays.toString(D));
	}
}
