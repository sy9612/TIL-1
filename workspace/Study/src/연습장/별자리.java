package 연습장;

import java.util.LinkedList;
import java.util.Scanner;



public class 별자리 {
	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		};
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int map[][] = new int[10][10];
			for(int i=0;i<10;i++) {
				for(int j=0; j<10; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int result = 0;
			boolean[][] check = new boolean[10][10];
			
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (check[i][j] == false && map[i][j] == 1) {
						Node buf = new Node(i, j);
						
						//bfs//
						LinkedList<Node> q = new LinkedList<>();
						check[buf.i][buf.j] = true;
						q.add(buf);
						int dr[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
						int dc[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
						while (!q.isEmpty()) {
							Node ndot = q.poll();
							for (int d = 0; d < 8; d++) {
								int r = ndot.i + dr[d];
								int c = ndot.j + dc[d];

								if (r >= 0 && c >= 0 && r < 10 && c < 10 && check[r][c] == false && map[r][c] == 1) {
									check[r][c] = true;
									Node n = new Node(r, c);
									q.add(n);
								}
							}
						}
						//

						result++;
					}
				}
			}
			System.out.println(result);

		}
		
	}
}
