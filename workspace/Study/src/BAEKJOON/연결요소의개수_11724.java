package BAEKJOON;

import java.util.Scanner;

public class 연결요소의개수_11724 {

	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean check[] = new boolean[N+1];
		int arr[][] = new int[N+1][N+1];
		for(int i=0;i <M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			if(dfs(check,arr,i))
				cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean dfs(boolean[] check, int[][] arr,int v) {
		if(check[v] == true)
			return false;
		
		//System.out.println(v);
		check[v] = true;
		for(int i=1; i<arr[v].length; i++) {
			if(check[i] == false && arr[v][i] == 1) {
				dfs(check, arr, i);
			}
		}
		return true;
	}

}
