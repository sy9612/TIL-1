package BAEKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소스패닝트리_1197 {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] edges = new int[E][3];
		parents = new int[V+1];
		rank = new int[V+1];
		for(int i=0; i< E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt(); //가중치
		}
		// 간선들을 가중치 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				//o1[2] o2[2]
				return Integer.compare(o1[2], o2[2]);
			}
		});
		// 각 정점에 대해 유니온파인드로 연산 준비
		for(int i=0; i<V+1; i++)
			makeSet(i);
		int result = 0;
		int cnt = 0;
		for(int i=0; i<E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a == b) continue; //같은 라인이면은 pass
			union(a, b);
			// 간선 선택
			result += edges[i][2]; //가중치 더하기
			// 정점의 개수 -1번 반복하면 그만
			cnt++;
			if(cnt == V-1) break;
		}
		
		System.out.println(result);
	}
	static void makeSet(int x) {
		parents[x] = x;
	}
	static int findSet(int x) {
		if( x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else {
			parents[px] = py;
			if( rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
}
