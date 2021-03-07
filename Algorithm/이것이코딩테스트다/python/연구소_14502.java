package python;

import java.util.Scanner;

public class 연구소_14502 {

	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		int[] vir = new int[2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2)
				{
					vir[0] = i;
					vir[1] = j;
				}
			}
		}
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		
		
	}
}
