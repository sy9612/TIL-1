package sw_expert;

import java.util.*;


public class 종구의딸이름짓기 {
	static int N;
	static int M;
	static char[][] map;
	static class Node {
		int i;
		int j;
		String name;

		Node(int i, int j, String name) {
			this.i = i;
			this.j = j;
			this.name = name;
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				String buf = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = buf.charAt(j);
				}
			}
			PriorityQueue<String> result = new PriorityQueue<>();
			LinkedList<Node> q = new LinkedList<>();
			boolean visited[][] = new boolean[N][M];
			q.add(new Node(0,0,""));
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				Node buf = q.poll();
				String n = buf.name;
				n += map[buf.i][buf.j];
				
				if(buf.i == N-1 && buf.j == M-1) {
					result.add(n);
					continue;
				}
				
				if(buf.i+1<N && buf.j+1<N && map[buf.i+1][buf.j] <= map[buf.i+1][buf.j])
				{
					q.add(new Node(buf.i+1, buf.j, n));
				}
				else if(buf.i+1<N && buf.j+1<N && map[buf.i+1][buf.j] > map[buf.i+1][buf.j]) {
					q.add(new Node(buf.i, buf.j+1, n));
				}
			}
			System.out.println(result.poll());
		}

	}

}
