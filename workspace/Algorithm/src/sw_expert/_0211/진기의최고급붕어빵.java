package sw_expert._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵 {
	static int N, M, K;
	static int[] person;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			 N = sc.nextInt();
			 M = sc.nextInt();
			 K= sc.nextInt();
			 person = new int[11112];
			int sign = 0;
			for(int i=0; i<N; i++) {
				int buf = sc.nextInt();
				if(buf < M)
					sign = 1;
				person[buf]++;
			}
			
			if (sign == 1) {
				System.out.println("#" + tc + " Impossible");
				continue;
			}
				
			
			if(bbang())
				System.out.println("#" + tc + " Possible");
			else
				System.out.println("#" + tc + " Impossible");
		}
	}

	private static boolean bbang() {
		int cnt = 0;
		int cp = 0;
		for(int i=1; cp< N; i++) {
			if(i%M == 0)
			{
				cnt += K;
			}
			if(person[i] > 0) {
				if(cnt == 0)
					return false;
				
				cnt = cnt -person[i];
				if(cnt <0)
					return false;
				
				cp += person[i];
				person[i] = 0;
			}
		}
		return true;
	}
}
