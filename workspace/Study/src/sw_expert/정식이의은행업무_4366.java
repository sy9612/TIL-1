package sw_expert;

import java.util.HashSet;
import java.util.Scanner;

public class 정식이의은행업무_4366 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			String N = sc.next();
			String M = sc.next();
			
			HashSet<Integer> hash = new HashSet<>();
			
			for (int i = 0; i < N.length(); i++) {
				if(N.charAt(i) == '0') {
					StringBuilder sb = new StringBuilder(N);
					sb.setCharAt(i, '1');
					hash.add(Integer.parseInt(sb.toString(),2));
				}
				else {
					StringBuilder sb = new StringBuilder(N);
					sb.setCharAt(i, '0');
					hash.add(Integer.parseInt(sb.toString(),2));
				}
			}
			int result = 0;
			for (int i = 0; i < M.length(); i++) {
				if(M.charAt(i) == '0') {
					StringBuilder sb = new StringBuilder(M);
					sb.setCharAt(i, '1');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
					sb = new StringBuilder(M);
					sb.setCharAt(i, '2');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
				}
				else if(M.charAt(i) == '1') {
					StringBuilder sb = new StringBuilder(M);
					sb.setCharAt(i, '0');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
					sb = new StringBuilder(M);
					sb.setCharAt(i, '2');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
				}
				else {
					StringBuilder sb = new StringBuilder(M);
					sb.setCharAt(i, '0');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
					sb = new StringBuilder(M);
					sb.setCharAt(i, '1');
					if(hash.contains(Integer.parseInt(sb.toString(),3))) {
						result = Integer.parseInt(sb.toString(),3);
						break;
					}
				}
			}
			System.out.println(result);
		}
		
	}
}
