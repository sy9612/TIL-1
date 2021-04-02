package Jungol._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 종교 {
	static int []parents;
	static int []rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parents = new int[N+1];
		rank = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			unionSet(a,b);
		}
		boolean check[] = new boolean[N+1];
		for(int i=1; i<N; i++) {
			check[parents[i]] = true;
		}
		int cnt = 0;
		for(int i=1; i<N; i++)
		{
			if(check[i] == true)
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void unionSet(int a, int b) {
		// TODO Auto-generated method stub
		int px = findSet(a);
		int py = findSet(b);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else if(rank[px] < rank[py]) {
			parents[px] = py;
		}
		else {
			parents[px] = py;
			rank[py]++;
		}
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if( x == parents[x])
			return x;
		else {
			//아니라면 부모에 대해 대표자 찾기 재귀호출
			parents[x] =  findSet(parents[x]);
			return parents[x];
		}
	}
}
