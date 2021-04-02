package BAEKJOON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 레이저통신_6087 {
	static int H, W;
	static char[][] map;
	static class Node {
		int i; //x
		int j; //
		int d; //방향
		int cnt; //거울개수

		Node(int i, int j,int d, int cnt) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.cnt = cnt;
		};
	}
	static Node leser;
	static int[] dr = {0, 0, 0, 1, -1 };
	static int[] dc = {0, 1, -1, 0, 0 }; //우좌하상
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		
		map = new char[H][W];
		leser = new Node(-1,0,0,0);
		int visited[][] = new int[H][W];
		
		for(int i=0; i<H; i++) {
			String st = sc.next();
			for(int j=0;j<W; j++) {
				map[i][j] = st.charAt(j);
				visited[i][j] = Integer.MAX_VALUE;
				if(map[i][j] == 'C' && leser.i == -1) {
					leser = new Node(i,j,0,0);
				}
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		//방향을 담고 있어서 방향이 바뀔때마다 count +1;
		//방향 변수, count 변수 필요
		//우좌하상 0123
		
		q.add(leser);
		visited[leser.i][leser.j] = -1;
		int ret = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node buf = q.poll();
			for (int d = 1; d < 5; d++) {
				int r = buf.i + dr[d];
				int c = buf.j + dc[d];
				
				if(IsIn(map,r,c)) {
					if(map[r][c] == '*') continue;
					int next = buf.cnt;
					if(d != buf.d && buf.d != 0) 
						next += 1;
					
					if(map[r][c] == '.' && visited[r][c] >= next) {
						visited[r][c] = next;
						q.add(new Node(r,c,d,next));
					}
					else if(map[r][c] == 'C' && !(r == leser.i && c == leser.j)) {
						ret = Math.min(ret, next);
						visited[r][c] = next;
					}
				}
				
			}
		}
		System.out.println(ret);
	}
	private static boolean IsIn(char[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
