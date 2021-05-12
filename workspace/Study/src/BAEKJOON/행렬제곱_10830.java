package BAEKJOON;

import java.util.Scanner;

public class 행렬제곱_10830 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		int[][] a = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
