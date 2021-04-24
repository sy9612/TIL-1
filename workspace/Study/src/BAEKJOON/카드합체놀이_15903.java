package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 카드합체놀이_15903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long m = sc.nextInt();
		
		long[] arr = new long[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			Arrays.sort(arr);
			
			long x = arr[0];
			long y = arr[1];
			
			arr[0] = x+y;
			arr[1] = arr[0];
		}
		long result=0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		
		System.out.println(result);
	}
}
