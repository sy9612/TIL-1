package baekjoon._0210;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기_Solution {

	static int N;
	static int[][] map;
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		int num = 0;
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j] == 1)
					num++;
			}
		}
		int dr[] = {-1,1,0,0};
		int dc[] = {0, 0, 1, -1};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					int cnt =0 ;
					Queue<Node> queue =new LinkedList<>();
					queue.add(new Node(i,j));
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						cnt++;
						for(int d=0; d<4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];
							if(nr < 0 || nc < 0 || nr>=N || nc>= N)
								continue;
							if(map[nr][nc] != 0)
								map[nr][nc] = 0;	
							queue.add(new Node(nr,nc));
						}
					}
					pq.add(cnt);
				}
			}
		}
		
		System.out.println(num);
		
	}

}
