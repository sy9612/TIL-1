package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 월간챌린지_3 {
	private static int[][] map;
	private static int n;

	public static void main(String[] args) {
		int[] a = { -5, 0, 2, 1, 2 };
		int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };
//		int[] a = {0, 1, 0};
//		int[][] edges = {{0,1},{1,2}};
		solution(a, edges);
	}

	static class Node {
		int idx;
		int go;
		int cnt;

		Node(int idx, int go, int cnt) {
			this.idx = idx;
			this.go = go;
			this.cnt = cnt;
		}
	}

	public static long solution(int[] a, int[][] edges) {
`		long answer = -1;

		n = a.length;

		al = new ArrayList[a.length];
		for (int i = 0; i < a.length; i++) {
			al[i] = new ArrayList<>();
		}
//
		for (int i = 0; i < edges.length; i++) {
			al[edges[i][0]].add(edges[i][1]);
			al[edges[i][1]].add(edges[i][0]);
		}
//		
//		for (int i = 0; i < al.length; i++) {
//			Collections.sort(al[i], new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					// TODO Auto-generated method stub
//					
//					if(a[o1] >= a[o2])
//						return 1;
//					else return -1;
//					
//				}
//				
//			});
//		}
//		
		arr = a;
		long max = -1;
		check = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if(check[i]) continue;
			long sum = a[i];
			long cnt = 0;
			
			for (int j = 0; j < al[i].size(); j++) {
				sum += a[al[i].get(j)];
				cnt += Math.abs(a[al[i].get(j)]);
				check[al[i].get(j)] = true;
			}
			
			
//			System.out.println(sum + " "+ cnt);
			if(sum == 0) {
				max = Math.max(max, cnt);
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			if(check[i]) continue;
			asum = 0;
			acnt = Math.abs(a[i]);
			
			dfs(i, 0);
//				sum += a[al[i].get(j)];
//				cnt += Math.abs(a[al[i].get(j)]);

			System.out.println(asum + " " + acnt);
//			System.out.println(sum + " "+ cnt);
			if (asum == 0) {
				max = Math.max(max, acnt);
			}
			else {
				max = -1;
				break;
			}

		}
		System.out.println(max);
		answer = max;
		return answer;
	}

//		
//		arr = a;
//		check = new boolean[n];
//		Queue<Node> q = new LinkedList<>();
//		for (int i = 0; i < n; i++) {
//			if(!check[i]) {
//				q.add(new Node(i, arr[i], 0));
//				check[i] = true;
//				
//				while(!q.isEmpty()) {
//					Node buf = q.poll();
//					for (int j = 0; j < al[buf.idx].size(); j++) {
//						q.add(new Node(al[buf.idx].get(i), buf.go - arr[al[buf.idx].get(i)], buf.cnt+arr[al[buf.idx].get(i)]))
//					}
//					
//				}
//				
//			}
//		}
//
//		return answer;
//	}

	static int[] arr;
	static boolean[] check;
	static ArrayList<Integer>[] al;
	static long asum;
	static long acnt;

	private static void dfs(int i, long sum) {
		// TODO Auto-generated method stub
		check[i] = true;
		asum += arr[i];
		acnt += Math.abs(sum);
		System.out.println(sum);
		for (int j = 0; j < al[i].size(); j++) {
			if (!check[al[i].get(j)]) {
				dfs(al[i].get(j), sum - arr[i] + arr[al[i].get(j)]);
			}
		}

	}
}
