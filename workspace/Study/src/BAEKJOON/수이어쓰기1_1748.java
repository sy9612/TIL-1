package BAEKJOON;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1748
public class 수이어쓰기1_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int result = 0;
		int size = N.length();
		
		for(int i=0; i< size-1; i++) {
			result += 9*(Math.pow(10, i))*(i+1);
		}
		int a = (int)Math.pow(10, size-1);
		
		for(int i=a; i<=Integer.parseInt(N); i++) {
			result += size;
		}
		System.out.println(result);
		
	}
}
