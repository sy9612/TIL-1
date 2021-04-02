package BAEKJOON;

import java.util.*;
class dot3{
	int i;
	int j;
	
	dot3(int i, int j){
		this.i = i;
		this.j = j;
	};
}
public class 미로탐색_2178 {
	static int N;
	static int M;
	static int map[][];
	static boolean check[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		check = new boolean[N][M];
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String buf = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = buf.charAt(j) - '0';
			}
		}
		dot3 dbuf = new dot3(0,0);
		bfs(dbuf);
		System.out.println(map[N-1][M-1]);
	}
	private static void bfs(dot3 dbuf) {
		LinkedList<dot3> q = new LinkedList<>();
		check[dbuf.i][dbuf.j] = true;
		q.add(dbuf);
		
		int dr[] = {1,-1,0,0};
		int dc[] = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			dot3 miro = q.poll();
			for(int i=0; i<4; i++) {
				int r = miro.i + dr[i];
				int c = miro.j + dc[i];
				
				if(r>=0 && c>=0 && r<N && c<M && map[r][c] == 1 && check[r][c] == false) {
					check[r][c] = true;
					map[r][c] = map[miro.i][miro.j]+1;
					dot3 m = new dot3(r,c);
					q.add(m);
				}
				if(r == N-1 && c == M-1)
					break;
			}
		}
		
	}

}
