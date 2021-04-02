package 기출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		tree = new int[N + 1][3];

		// 0 left 1 right 2 parent
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int a = sc.nextInt();
			if (a == 0) {
				continue;
			} else if (tree[a][0] == 0) {
				tree[a][0] = i;
				tree[i][2] = a;
			} else {
				tree[a][1] = i;
				tree[i][2] = a;
			}
		}

		for (int i = 0; i < M; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int visited[] = new int[N+1];
			visited[a] = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			while(!q.isEmpty()) {
				int buf = q.poll();
				if(tree[buf][0] != 0) {
					visited[tree[buf][0]] += 1;
					q.add(tree[buf][0]);
				}
				if(tree[buf][1] != 0) {
					visited[tree[buf][1]] += 1;
					q.add(tree[buf][1]);
				}
			}
			
			q.add(b);
			
			while(!q.isEmpty()) {
				int buf = q.poll();
				if(tree[buf][0] != 0) {
					visited[tree[buf][0]] += 1;
					q.add(tree[buf][0]);
				}
				if(tree[buf][1] != 0) {
					visited[tree[buf][1]] += 1;
					q.add(tree[buf][1]);
				}
			}
			
			for(int num=1; num<N+1; num++) {
				if(visited[num] == 1) {
					if(num != a && num != b) {
						result++;
					}
				}
			}
			
		}
		System.out.println(result);
	}
}
