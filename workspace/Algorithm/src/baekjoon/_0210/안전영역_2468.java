package baekjoon._0210;

import java.util.LinkedList;
import java.util.Scanner;

public class 안전영역_2468 {
	static class Dot{
		int i;
		int j;
		Dot(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	static int map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		map = new int[N][N];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(max<map[i][j])
					max = map[i][j];
			}
		}
		int result = 1;
		for(int an = 1; an<=max; an++) {
			boolean check[][] = new boolean[N][N];
			int cnt =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(map[i][j] > an && check[i][j] == false) {
						bfs(new Dot(i,j), check, an);
						cnt++;
					}
				}
			}
			if(result<cnt)
				result = cnt;
		}
		System.out.println(result);
	}
	private static void bfs(Dot dot, boolean check[][], int an) {
		LinkedList<Dot> q = new LinkedList<>();
		q.add(dot);
		int dr[] = {1,-1,0,0};
		int dc[] = {0,0,1,-1};
		while(!q.isEmpty()) {
			Dot buf = q.poll();
			for(int i=0; i<4; i++) {
				int r = buf.i + dr[i];
				int c = buf.j + dc[i];
				
				if(r>=0 && c>=0 && r < check.length && c < check.length) {
					if(map[r][c] > an && check[r][c] == false) {
						check[r][c] = true;
						q.add(new Dot(r,c));
					}
				}
			}
		}
	}

}
