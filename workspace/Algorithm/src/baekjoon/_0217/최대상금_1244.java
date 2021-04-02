package baekjoon._0217;

import java.util.*;

public class 최대상금_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");

			String n = sc.next();
			StringBuilder N = new StringBuilder(n);
			int C = sc.nextInt();
			
			int result=0;
			
			for (int k = 0; k < C; k++) {
				int max = 0;
				int max_i = 0;
				int min_i = 0;
				int min = 1000000;

				for (int i = 0; i < N.length(); i++) {
					int buf = N.charAt(i) - '0';
					if (buf < min) {
						min_i = i;
						min = buf;
					} 
					if (buf >= max) {
						max_i = i;
						max = buf;
					}
				}

				if (min_i < max_i) {
					StringBuilder copy = N;
					char tmp = copy.charAt(min_i);
					copy.setCharAt(min_i, copy.charAt(max_i));
					copy.setCharAt(max_i, tmp);

					if(result < Integer.parseInt(copy.toString())) {
						result = Integer.parseInt(copy.toString());
						N = copy;
					}
					
				}

			}
			System.out.println(N);
		}
	}
}
