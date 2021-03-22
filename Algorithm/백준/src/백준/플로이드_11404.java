package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드_11404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] city = new int[N+1][N+1];
		
		for (int i = 0; i < city.length; i++) {
			Arrays.fill(city[i], 987654321);
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(city[a][b] > c) {
				city[a][b] = c;
			}
		}
		
		
		for (int k = 1; k < city.length; k++) {
			for (int i = 1; i < city.length; i++) {
				for (int j = 1; j < city.length; j++) {
					
					if(i != j && city[i][j] > city[i][k] + city[k][j]) {
						city[i][j] = city[i][k] + city[k][j];
					}
					
				}
			}
		}
		
		for (int i = 1; i < city.length; i++) {
			for (int j = 1; j < city.length; j++) {
				if(city[i][j] == 987654321) System.out.print(0 + " ");
				else System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}
