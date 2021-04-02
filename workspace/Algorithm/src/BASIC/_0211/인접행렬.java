package BASIC._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 인접행렬 {

	//첫 줄에는 정점의 개수와 간선의 개수가 주어지고, 두 번째 줄부터 간선의 개수만큼 두 정점이 연결된 정보가 주어짐
	// 7 8
	// 1 2
//	1 3
//	2 4
//	2 5
//	4 6
//	5 6
//	6 7
//	3 7
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 8 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");
		
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		int arr[][] = new int[V][V];
		
		for(int i=0; i<E; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			
			arr[r][c] = 1;
			arr[c][r] = 1;
		}
		
		for(int i=0; i<V; i++) {
				System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}
