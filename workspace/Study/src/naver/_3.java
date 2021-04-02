package naver;

import java.util.Arrays;

public class _3 {
	public static void main(String[] args) {
		int k = 6;
		
		solution(k);
	}
	static long ans = 0;
	private static boolean[] num_c;
	private static int[] num;
	public static long solution(int k ) {
		long answer = 0;
		
		
		num = new int[10];
		num[0] = 6;
		num[1] = 2;
		num[2] = 5;
		num[3] = 5;
		num[4] = 4;
		num[5] = 5;
		num[6] = 6;
		num[7] = 3;
		num[8] = 7;
		num[9] = 6;
		
		
		 num_c = new boolean[10];
	
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if(k > num[i]) {
				num_c[i] = true;
				max = Math.max(max, k/num[i]);
			}
			else if(k == num[i]) {
				answer++;
			}
		}
		
		for (int i = 2; i < max+1; i++) {
			perm(0, new int[i], k);
		}
		
		answer += ans;
		System.out.println(answer);
		return answer;
	}
	
	static void perm(int idx, int[] sel, int k) {
		//원하는 만큼 골랐으므로, 결과 뽑고 리턴
		if(idx == sel.length) {
			int cnt = 0;
			for (int i = 0; i < sel.length; i++) {
				cnt += num[sel[i]];
			}
			
			if(cnt == k) {
				ans++;
				if(num_c[0] == true) {
					if(cnt + num[0] == k) {
						ans += sel.length;
					}
				}
			}
			
			return;
		}
				
		
		if(idx == sel.length) {
			return;
		}
		for(int i=1; i<10; i++) {
				sel[idx] = i;
				perm(idx+1, sel, k);
		}
		
	}
}
