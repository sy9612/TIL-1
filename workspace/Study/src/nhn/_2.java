package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2 {
	private static int[] check;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int M = Integer.parseInt(st[1]);
		int D = Integer.parseInt(st[2]);
		
		int[] H = new int[M];
		st = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			H[i] = Integer.parseInt(st[i]);
		}
		
		result = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < H.length; i++) {
			check = new int[N];
			for (int j = 0; j < H.length; j++) {
				check[H[j]]=2;
			}
			dfs(i);
			
			int a =0;
			int b =0;
			boolean c = true;
			for (int j = 0; j < check.length; j++) {
				if(check[j] == 2) {
					a++;
				}
				else if(check[j] == 1) {
					b++;
					if(a >=D) {
						c = false;
					}
					a = 0;
				}
			}
			
			if(c) {
				if(result > b) {
					result = b;
				}
			}
			
		}
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(result);
		
	}

	private static void dfs(int i) {
		if(i >= check.length) {
			return;
		}
		
		
		for (int j = 0; j < check.length; j++) {
			if((i+j)<check.length && check[i+j] ==0) {
				check[i] = 1;
				dfs(i+j);
				check[i] = 0;
			}
		}
	}
}
