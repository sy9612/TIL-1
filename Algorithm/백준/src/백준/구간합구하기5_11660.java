package 백준;

import java.util.Scanner;

public class 구간합구하기5_11660 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N+1][N+1];
		int[] sum = new int[N*M+1];
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int a = sc.nextInt();
				arr[i][j] = arr[i][j-1] + a;
				sum[N*i + j] = sum[N*i + j -1] + a;
			}
		}
		
		for (int m = 0; m < M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int rs = 0;
			
			rs = sum[N*x + y] - sum[N*i + j -1];
			
			for (int k = 0; k <= x-i; k++) {
				
			}
			
			
			System.out.println(rs);
		}
	}
}
