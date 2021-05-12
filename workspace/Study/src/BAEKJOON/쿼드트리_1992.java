package BAEKJOON;

import java.util.Scanner;

public class 쿼드트리_1992 {
	static String rs = "";
	private static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = st.charAt(j);
			}
		}
		tree(0, 0, N);
		System.out.println(rs);
		
	}
	private static void tree(int r, int c, int n) {
		// TODO Auto-generated method stub
		
		char num = arr[r][c];
		if(n == 1) {
			rs += num;
			return;
		}
		boolean ok = true;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(num != arr[i][j]) {
					ok = false;
					rs += "(";
					for (int k = 0; k < 2; k++) {
						for (int l = 0; l < 2; l++) {
							tree(r + (n/2)*k, c + (n/2)*l, n/2);
						}
					}
					rs += ")";
					
					break;
				}
			}
			if(!ok) break;
		}
		if(ok) {
			rs += num;
			return;
		}
		
		
	}
}
