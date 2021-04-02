package sw_expert._0211;

import java.util.Scanner;

public class 서로소집합 {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			parents = new int[N+1];
			rank = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				parents[i] = i;
			}
			for(int i=0; i<M; i++) {
				int p = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(p == 0) {
					unionSet(x,y);
				}
				if(p== 1) {
					if(findSet(x) == findSet(y))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	static int findSet(int x) {
		if(x == parents[x])
			return x;
		else {
			parents[x] =  findSet(parents[x]);
			return parents[x];
		}
	}
	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else if(rank[px] < rank[py]) {
			parents[px] = py;
		}
		else {
			parents[py] = px;
			rank[px]++;
		}
		
	}
}
