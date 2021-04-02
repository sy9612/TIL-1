package 연습장;

import java.util.Arrays;
import java.util.Scanner;

public class 달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int col = y;
		int row = x;
		
		int map[][] = new int[x][y];
		
		int cc = -1; int rr = 0;
		for (int num = 1; num <= x*y;) {
			
			for (int c = cc+1; c < col; c++) {
				map[rr][c] = num++;
			}
			--col;
			cc++;
			for (int r = rr+1; r <row; r++) {
				map[r][col] = num++;
			}
			--row;
			rr++;
			for(int c = col-1; c >= cc; c--) {
				map[row][c] = num++;
			}
			for (int r = row-1; r >= rr; r--) {
				map[r][cc] = num++;
			}
		}
		
		print(map);
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
