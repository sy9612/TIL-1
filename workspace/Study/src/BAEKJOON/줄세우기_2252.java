package BAEKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상 정렬
public class 줄세우기_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer>[] al = new ArrayList[N+1];
		
		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Integer>();
		}
		
		int[] cnt = new int[N+1];
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			al[A].add(B);
			cnt[B]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(cnt[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			System.out.print(x + " ");
			
			for (int i = 0; i < al[x].size(); i++) {
				if(--cnt[al[x].get(i)] == 0) q.add(al[x].get(i));
			}
			
		}
		
		
	}
}
