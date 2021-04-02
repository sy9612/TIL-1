package BAEKJOON;

import java.util.Scanner;

public class DFS와BFS_1260 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		int arr[][] = new int[N][N];
		
		for(int i=0; i<5; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a>b)	arr[b][a] = 1;
			else arr[a][b] = 1;
		}
		
		boolean check[] = new boolean [N];
	
	}
	
}
