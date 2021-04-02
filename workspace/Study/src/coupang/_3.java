package coupang;

import java.util.HashMap;
import java.util.HashSet;

public class _3 {
	public static void main(String[] args) {
		int[] score = {
			1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100
		};
		solution(2, score);
	}
	public static int solution(int k, int[] score) {
		int answer = 0;
		
		int[] top = new int[score.length];
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < score.length-1; i++) {
			int c = score[i] - score[i+1];
			top[i+1] = c;
			
			if(hm.containsKey(c)) 
				hm.replace(c, hm.get(c) + 1);
			else 
				hm.put(c, 1);

			if(hm.get(c) >= k) {
				hs.add(c);
			}
		}
		
		boolean[] check = new boolean[top.length];
		for (int i = 1; i < top.length; i++) {
			if(hs.contains(top[i])) {
				check[i] = true;
				check[i-1] = true;
			}
		}
		
		for (int i = 0; i < check.length; i++) {
			if(!check[i])
				answer++;
		}
		System.out.println(answer);
		
		return answer;
	}
}
