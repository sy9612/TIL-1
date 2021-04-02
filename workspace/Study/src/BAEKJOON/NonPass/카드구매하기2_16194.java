package BAEKJOON.NonPass;

import java.util.Scanner;

public class 카드구매하기2_16194 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int card[] = new int[N+1];
	static int[] d; 
	public static void main(String[] args) {
		d = new int[N+1];
		
		for(int i=1; i<N+1 ;i++) {
			card[i] = sc.nextInt();
			d[i] = card[i];
		}
		
		System.out.println(go(N));
		
	}
	
	private static int go(int num) {
		if(num == 0) return 0;
		if(num == 1) return card[1];
		if(d[num] > 0) return d[num];
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum = go(num-i) + card[i];
			if(sum < d[num])
				d[num] = sum;
		}
		
		return d[num];
		
	}
}
