package kakaotest;

import java.util.ArrayList;
import java.util.HashSet;

public class _3 {
	public static void main(String[] args) {

		String[] a = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = solution(a);
		System.out.println(answer[0] + ", " + answer[1]);
	}

	public static int[] solution(String[] gems) {
		int[] answer = { 0, 0 };

		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < gems.length; i++) {
			hs.add(gems[i]);
		}

		int[] d = new int[gems.length];

		d[0] = 1;
		hs.remove(gems[0]);
		int result = Integer.MAX_VALUE;

		int i;
		for ( i = 1; i < gems.length; i++) {
			if(hs.isEmpty()) {
				int s = 0;
				int j;
				for ( j = 0; j < d.length; j++) {
					if(d[j] == 1) {
						s = j;
					}
				}
				if(result > i-s) {
					result = i-s;
					answer[0] = s+1;
					answer[1] = i;
				}
				
			}
			if(hs.contains(gems[i])) {
				hs.remove(gems[i]);
				d[i] = d[i-1]+1;
			}
			else {
				for (int j = 0; j <i; j++) {
					if(!hs.contains(gems[j])) {
						hs.add(gems[j]);
						d[j] = 1;
					}
				}

			}
		}
		if(hs.isEmpty()) {
			int s = 0;
			int j;
			for ( j = 0; j < d.length; j++) {
				if(d[j] == 1) {
					s = j;
				}
			}
			if(result > i-s) {
				result = i-s;
				answer[0] = s+1;
				answer[1] = i;
			}
			
		}
		
		return answer;
	}
}
