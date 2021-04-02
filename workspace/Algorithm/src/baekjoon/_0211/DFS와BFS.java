package baekjoon._0211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		int arr[][] = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			arr[r][c] = 1;
			arr[c][r] = 1;
		}
		
		boolean check[] = new boolean[N+1];
		
		//정점별로 방문체크를 하기 위한 방문 배열 준비
		//시작 정점을 매개로 DFS 함수 호출
		DFS(arr, V, check);
		System.out.println();
		
		check = new boolean[N+1];
		BFS(arr, V, check);
	}

	private static void DFS(int[][] arr, int v, boolean[] check) {
		System.out.print(v+" ");
		check[v] = true;
		//현재 정점과 연결 된 모든 정점들에 대해
		for(int i=1; i<arr.length; i++) {
			//아직 방문하지 않앗다면 해당 정점에 대해 DFS 호출
			if(arr[v][i] == 1 && check[i] == false)
				DFS(arr,i,check);
		}
	}
	
	private static void BFS(int[][] arr, int v, boolean[] check) {
		//큐와 방문 배열 준비
		//처음 방문할 정점을 큐에 삽입하고, 방문 체크
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		check[v] = true;
		
		//큐가 빌 때까지 반복
		
		while(!q.isEmpty()) {
			//큐에서 하나 꺼내 방문
			int buf = q.poll();
			System.out.print(buf + " ");
			for(int i=1; i<arr.length; i++) {
				//연결되어 있는 노드 중 방문하지 않은 노드를 큐에 삽입하고 방문 체크
				if(arr[buf][i] == 1 && check[i] == false) {
					check[i] = true;
					q.add(i);
				}
			}
		}
		
	}
}
