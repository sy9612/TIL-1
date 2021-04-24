package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 차이를최대로_10819 {
	private static int[] result;
	private static boolean[] visited;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		arr = new int[N];
		for (int i = 0; i < st.length; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}

		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
		
		System.out.println(max);

	}

	static int max =0;
	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if (idx == result.length) {
//			System.out.println(Arrays.toString(result));
			int sum = 0;
			for (int i = 0; i < result.length-1; i++) {
				sum += Math.abs(result[i] - result[i+1]);
			}
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
