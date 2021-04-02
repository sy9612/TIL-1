package BAEKJOON;

import java.util.Scanner;

public class 가르침_1062 {
	static int N;
	static int K;
	static String[] word;
	static String beta = "";
	static boolean alpha[];
	static int max = 0;
	static char[] combr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		word = new String[N];

		for (int i = 0; i < N; i++) {
			word[i] = sc.next();
		}

		alpha = new boolean[123];

		String nes = "antic";
		for (int i = 0; i < nes.length(); i++) {
			if (alpha[nes.charAt(i)] == false) {
				alpha[nes.charAt(i)] = true;
			}
		}
		K -= 5;
		if(K<0)
		{
			System.out.println(0);
			return;
		}
		
		boolean[] bet = alpha.clone();
		for (int i = 0; i < N; i++) {
			for (int j = 4; j < word[i].length() - 4; j++) {
				if (!bet[word[i].charAt(j)]) {
					bet[word[i].charAt(j)] = true;
					beta += word[i].charAt(j);
				}
			}
		}
		if(K>beta.length()) {
			System.out.println(N);
			return;
		}
		
		combr = new char[K];
		comb(0,0);
		
		System.out.println(max);
	}
		/*

		dfs(0);*/

	private static void comb(int idx, int sidx) {
		if(sidx == K) {
			int result = 0;
			String a = "";
			for(int i=0; i<K; i++) {
				a += combr[i];
			}
			a += "antic";
			for (int i = 0; i < N; i++) {
				boolean sign = false;
				for (int j = 4; j < word[i].length() - 4; j++) {
					String b = ""+word[i].charAt(j);
					if(!a.contains(b)) {
						sign = true;
						break;
					}
				}
				if(sign == false)
					result++;
			}

			if (max < result)
				max = result;
			return;
		}
		
		if(idx == beta.length())
			return;
		
		combr[sidx] = beta.charAt(idx);
		comb(idx+1,sidx+1);
		comb(idx+1,sidx);
		
	}


	/*private static void dfs(int idx) {
		if (idx == K) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				boolean sign = false;
				for (int j = 4; j < word[i].length() - 4; j++) {
					if (!alpha[word[i].charAt(j)]) {
						sign = true;
						break;
					}
				}

				if (!sign) {
					result++;
				}
			}

			if (max < result)
				max = result;
		}

		for (int j = 0; j < beta.length(); j++) {
			if (!alpha[beta.charAt(j)]) {
				alpha[beta.charAt(j)] = true;
				dfs(idx + 1);
				alpha[beta.charAt(j)] = false;
			}
		}

	}*/

}
