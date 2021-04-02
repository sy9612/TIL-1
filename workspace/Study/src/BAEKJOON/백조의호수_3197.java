package BAEKJOON;

import java.util.Scanner;

public class 백조의호수_3197 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		int[][] map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String a = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j);
				if(map[i][j] == 'L') {
					
				}
			}
		}
		
		
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		
		
		
	}
}
