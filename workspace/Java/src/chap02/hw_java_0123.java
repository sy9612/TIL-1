package chap02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hw_java_0123 {
	static int T;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("항공기지건설input.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			int min = 0;
			int max = 0;
			
			
		}
	}
}
