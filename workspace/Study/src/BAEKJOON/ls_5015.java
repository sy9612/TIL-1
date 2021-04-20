package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ls_5015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String P = sc.next();

		int N = sc.nextInt();
		LinkedList<String> rs = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String buf = sc.next();
			int[] p = new int[P.length()];
			int cur = 0;
			boolean ok = true;
			for (int j = 0; j < buf.length(); j++) {
				if (cur != p.length && P.charAt(cur) == '*') {
					p[cur++]++;
					ok = true;
				}
				if (cur != p.length && P.charAt(cur) == buf.charAt(j)) {
					p[cur++]++;
					ok = false;
				}
				else if(!ok && cur != p.length && P.charAt(cur) != buf.charAt(j))break;
				if(j == buf.length()-1) ok = true;
			}
			if (P.charAt(p.length - 1) != '*' && buf.charAt(buf.length() - 1) != P.charAt(p.length - 1))
				ok = false;
			for (int j = 0; j < p.length; j++) {
				if (p[j] == 0) {
					ok = false;
					break;
				}
			}
			if (ok)
				rs.add(buf);
		}

		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}
	}
}
