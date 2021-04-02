package BAEKJOON;

import java.util.*;
public class 가장긴증가하는부분수열4_14002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		
		ArrayList<Integer> []d = new ArrayList[N];
		for(int i=0; i<N; i++) {
			d[i] = new ArrayList<Integer>();
		}

		int result = 1;
		int resultx= 0;
		for (int i = 0; i < N; i++) {
			
			int max = 0;
			int buf = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && max < d[j].size()) {
					max = d[j].size();
					buf = j;
				}
			}
			if(buf>-1) {
				for(int j=0; j<d[buf].size(); j++)
					d[i].add(d[buf].get(j));
			}
			d[i].add(arr[i]);
			
			if (result < d[i].size()) {
				result = d[i].size();
				resultx = i;
			}
		}
		
		System.out.println(result);
		for(int i=0; i<d[resultx].size(); i++)
			System.out.print(d[resultx].get(i) + " ");
		System.out.println();
	}
}
