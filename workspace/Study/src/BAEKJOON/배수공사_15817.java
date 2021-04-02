package BAEKJOON;

import java.util.*;

public class 배수공사_15817 {
	static int N, x;
	static int[] L, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		x = sc.nextInt();
		L = new int[N];
		C = new int[N];
		result = 0;

		for (int i = 0; i < N; i++) {
			L[i] = sc.nextInt();
			C[i] = sc.nextInt();
			m.put(L[i], 0);
		}

		dfs(0);
		System.out.println(result);
	}

	static int result;
	static HashMap<Integer, Integer> m = new HashMap<>();
	static ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
	private static void dfs(int l) {
		
		if (l == x) {
			if (list.contains(m))
				return;
			
			HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>(m);
			result++;
			list.add(m1);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (C[i] != 0 && L[i] + l <= x) {
				C[i]--;
				m.replace(L[i], m.get(L[i]) + 1);
				dfs(l + L[i]);
				m.replace(L[i], m.get(L[i]) - 1);
				C[i]++;
			}
		}
	}
}
