package BAEKJOON;

import java.util.Scanner;

public class 잠수함식별_2671 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();

		
		String pattern = "(100+1+|01)+";
		System.out.println(st.matches(pattern) ? "SUBMARINE": "NOISE");
		
		/*10011001 일때 구분이 되지 않음*/
//		String p1 = "100~1~";
//		String p2 = "01";
//
//		String pattern = p1;
//		if (st.charAt(0) == '0') {
//			pattern = p2;
//		}
//
//		int pattern_idx = 0;
//		boolean ok = true;
//		for (int i = 0; i < st.length(); i++) {
//			if (pattern_idx == pattern.length()) {
//				pattern_idx = 0;
//				if (st.charAt(i) == '0') {
//					pattern = p2;
//				} else {
//					pattern = p1;
//				}
//			}
//			if (pattern.charAt(pattern_idx) == '~') {
//				if (pattern.charAt(pattern_idx - 1) != st.charAt(i)) {
//					pattern_idx++;
//					i--;
//				}
//			} else if (pattern.charAt(pattern_idx) == st.charAt(i)) {
//				pattern_idx++;
//			} else {
//				ok = false;
//				break;
//			}
//		}
//
//		if (ok && pattern_idx == pattern.length() || ok && pattern == p1 && pattern_idx == pattern.length()-1)
//			System.out.println("SUBMARINE");
//		else
//			System.out.println("NOISE");
	}
}
