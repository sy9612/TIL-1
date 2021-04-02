package sw_expert;

import java.util.Scanner;

public class String_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			System.out.print("#" + tc + " ");
			String search = sc.next();
			String s = sc.next();
			
			int result = 0;
			for(int i=0; i<=s.length()-search.length(); i++) {
				String a = s.substring(i,i+search.length());
				if(a.equals(search)) {
					result++;
				}
			}
			
			System.out.println(result);
		}
	}
}
