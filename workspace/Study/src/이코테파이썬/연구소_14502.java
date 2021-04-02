package 이코테파이썬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_14502 {

	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		
		int cnt = 0;
		
		dfs(0,0,0);

		System.out.println(max);
	}
	static int max = 0;
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	private static void dfs(int r, int c, int cnt) {
		// TODO Auto-generated method stub
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		if (cnt == 3) {
			// 벽을 다 세웠으니까 바이러스 퍼트린 후 안전 개수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 2) {
						
						int[][] map2 = new int[N][M];
						
						for (int j2 = 0; j2 < N; j2++) {
							for (int k = 0; k < M; k++) {
								map2[j2][k] = map[j2][k];
							}
						}
						
						for (int k = 0; k < map2.length; k++) {
							System.out.println(Arrays.toString(map2[k]));
						}
						System.out.println();
						
						//bfs 시작
						Queue<Node> q = new LinkedList<>();
						boolean[][] check = new boolean[N][M];
						
						q.add(new Node(i,j));
						check[i][j] = true;
						
						while(!q.isEmpty()) {
							Node buf = q.poll();
							for (int d = 0; d < 4; d++) {
								int cr = buf.r + dr[d];
								int cc = buf.c + dc[d];
								
								if(cr<0 || cc<0 || cr>=N || cc>=M || map2[cr][cc] != 0 || check[cr][cc])
									continue;
								
								check[cr][cc] = true;
								map2[cr][cc] = 2;
								q.add(new Node(cr,cc));
							}
						}
						
						int rst =0;
						for (int k = 0; k < N; k++) {
							for (int k2 = 0; k2 < M; k2++) {
								if(map2[k][k2] == 0) {
									rst++;
								}
							}
						}
						
						for (int k = 0; k < map2.length; k++) {
							System.out.println(Arrays.toString(map2[k]));
						}
						System.out.println("-----");
						
						
						max = Math.max(max, rst);
					}
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					cnt++;
					dfs(i, j, cnt);
					map[i][j] = 0;
					cnt--;
				}
			}
		}

	}
}
