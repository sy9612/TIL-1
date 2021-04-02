package BAEKJOON;

import java.util.Scanner;

public class 물통_2251 {
	private static boolean[] arr;
	private static int A;
	private static int B;
	private static int C;

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		 A = sc.nextInt();
		 B = sc.nextInt();
		 C = sc.nextInt();
		
		
		arr = new boolean[C+1];
		arr[C] = true;
		
		dfs(0, 0, C);
	}

	private static void dfs(int a, int b, int c) {
		// TODO Auto-generated method stub
		if(a == 0 && !arr[c]) {
			arr[c] = true;
			return;
		}
		
		if(a != 0) {
			if(b != B) {
				
			}
			if(c != C) {
			}
		}
		
		if(b != 0) {
			
		}
		
		if(c != 0) {
			
		}
	}
}
