package BAEKJOON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class dot{
	int i=0;
	int j=0;
}

public class 단지번호붙이기_2667 {
	static int check[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int b_cnt = 0;
	static int N;
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int map[][] = new int[N][N];

		check = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String buf = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = buf.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(check[i][j] == 0 && map[i][j] !=0) {
					dot buf1 = new dot();
					buf1.i = i;
					buf1.j = j;
					bfs(map, buf1);
					b_cnt++;
				}
			}
		}
		System.out.println(b_cnt);
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++)
			System.out.println(result.get(i));
	}

	private static void bfs(int[][] map, dot tmp) {
		Queue<dot> q = new LinkedList<>();
		q.add(tmp);
		check[tmp.i][tmp.j] = 1;
		int cnt = 1;
		while(!q.isEmpty()) {
			dot buf2 = q.poll();
			for(int k=0; k<4; k++) {
				int r = buf2.i + dr[k];
				int c = buf2.j + dc[k];
				
				if(r>=0 && c>=0 && r<N && c<N && check[r][c] == 0 && map[r][c] == 1) {
					check[r][c] = 1;
					dot _new = new dot();
					_new.i = r;
					_new.j = c;
					q.add(_new);
					cnt++;
				}
			}
		}
		result.add(cnt);
	}

}
