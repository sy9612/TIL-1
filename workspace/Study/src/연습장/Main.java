package 연습장;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String arr = "";
		
		arr = sc.next();
		
		Long max = Long.MIN_VALUE;
		for(int i=0; i<arr.length()-K+1; i++) {
			
			String result = arr.substring(i, i+K);
			if(max < Long.parseLong(result)) {
				max = Long.parseLong(result);
			}

		}
		System.out.println(max);
		
		return;
	}
}
