package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

public class 벽부수고이동하기_2206 {

	static class Dot{
		int i;
		int j;
		int k;
		Dot(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}
	static int[][] map;
	static boolean[][] check;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		
		map = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(new Dot(0,0,0));
	}
	private static void bfs(Dot dot) {
		LinkedList<Dot> q = new LinkedList<>();
		q.add(dot);
		check[dot.i][dot.j]= true; 
		int ds[][][] = new int[N][M][2];
		ds[0][0][0] = 1;
		
		int dr[] = {0,0,1,-1};
		int dc[] = {1,-1,0,0};
		while(!q.isEmpty()) {
			Dot buf = q.poll();
			
			for(int i=0; i<4; i++) {
				int r = dr[i] + buf.i;
				int c = dc[i] + buf.j;
				print(ds);
				if(r>=0 && c>=0 && r<map.length && c<map[buf.i].length) {
					
					if(buf.k==0 && map[r][c] == 1 && ds[r][c][buf.k+1] == 0) {
						ds[r][c][buf.k+1] = ds[buf.i][buf.j][buf.k]+1;
						q.add(new Dot(r,c,buf.k+1));
					}
					else if(map[r][c] == 0&& ds[r][c][buf.k] == 0) {
						ds[r][c][buf.k] = ds[buf.i][buf.j][buf.k] + 1;
						q.add(new Dot(r,c,buf.k));
					}
					//print(ds);
				}
				
			}
		}
		
		if(ds[N-1][M-1][0] == 0 && ds[N-1][M-1][1] == 0)
		{
			System.out.println(-1);
		}
		else if(ds[N-1][M-1][0] == 0)
			System.out.println(ds[N-1][M-1][1]);
		else if(ds[N-1][M-1][1] == 0)
			System.out.println(ds[N-1][M-1][0]);
		else
			System.out.println(Math.min(ds[N-1][M-1][0], ds[N-1][M-1][1]));
	}
	

	private static void print(int ds[][][]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(ds[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
