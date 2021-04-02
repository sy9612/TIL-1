package BAEKJOON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 알파벳_1987 {
	static class Node{
		int i;
		int j;
		boolean[] memo;
		int cnt;
		Node(int i, int j, boolean[] memo, int cnt){
			this.i = i;
			this.j = j;
			this.memo = memo;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		 map = new char[R][C];
		for(int i=0; i<R; i++) {
			String buf = sc.next();
			for(int j=0; j<C; j++) {
				map[i][j] = buf.charAt(j);
			}
		}
		visited = new boolean[R][C];
		visited[0][0] = true;
		boolean memo[] = new boolean[123];
		memo[map[0][0]] = true;
		dfs(new Node(0,0,memo,1));
		System.out.println(max);
	}
	static char[][] map;
	static boolean visited[][];
	static int max = 0;
	static void dfs(Node buf) {
		if(max < buf.cnt)
			max = buf.cnt;
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		
		for(int d=0; d<4; d++) {
			int r = dr[d] + buf.i;
			int c = dc[d] + buf.j;
			
			if(r<0 || c<0 || r>=map.length || c>=map[buf.i].length)
				continue;
			else if(!visited[r][c]){
				visited[r][c] = true;
				if(!buf.memo[map[r][c]]) {
					buf.memo[map[r][c]] = true;
					dfs(new Node(r,c,buf.memo, buf.cnt+1));
					buf.memo[map[r][c]] = false;
				}
				visited[r][c] = false;
			}
		}
	}
	
}
