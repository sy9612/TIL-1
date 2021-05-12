package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class Moo게임_5904 {
	
	static String[] s;
	private static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		s = new String[N+1];
		
		s[0] = "moo";
		//메모리 초과 나는 방법
		
		int[] d = new int[N];
				
//		StringBuilder sb = new StringBuilder("moo");
		
//		int idx = 1;
//		while(true) {
//			sb.append("m");
//			for(int i = 0; i<idx+2; i++) {
//				sb.append("o");
//			}
//			
//			sb.append(s[idx-1]);
//			s[idx] = sb.toString();
//			
//			if(s[idx].length() >= N) {
//				System.out.println(s[idx].charAt(N-1));
//				//System.out.println(sb.toString());
//				break;
//			}
//			idx++;
//		}
	}

	
}
