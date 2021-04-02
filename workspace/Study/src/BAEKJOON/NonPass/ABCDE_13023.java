package BAEKJOON.NonPass;

import java.util.Scanner;

public class ABCDE_13023 {
	static int N;
	static int M;
	static int result = 0;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int arr[][] = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a>b)	arr[b][a] = 1;
			else arr[a][b] = 1;
		}

		function(arr,0, 1);
		System.out.println(result);
		

	}
	static int cnt = 0;
	private static boolean function(int[][] arr,  int r, int c) {
		if( cnt == 4) {
			result = 1;
			return true;
		}
		if(r>=N || c>= N)
			return false;

		int i;
		for (i = c; i < N; i++) {
			if(arr[r][i] == 1) {
				if(!visited[r] && !visited[i]) {
					cnt++;
					function(arr, i, i+1);
					visited[r] = true;
				}
				else if(visited[r] && !visited[i]) {
					cnt++;
					if(!function(arr,i,i+1))
						return false;
				}
				else if(!visited[r] && visited[i])
					return false;
			}
		}
		visited[r] = true;
		return false;
	}

}
