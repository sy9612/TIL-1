package BAEKJOON;

import java.util.*;

public class 가장긴증가하는부분수열_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int[] d = new int[N];

		d[0] = 1;
		int result = 1;

		for (int i = 1; i < N; i++) {

			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && max < d[j]) {
					max = d[j];
				}
			}
			d[i] = max + 1;

			if (result < d[i])
				result = d[i];
		}
		
		System.out.println(result);
	}

//	
//	int[] b = new int[5];
//	Arrays.sort(p);
//	LinkedList<Integer> q = new LinkedList<>();
//	for (int i = 0; i < p.length; i++) {
//		b[p[i]]++;
//		q.add(p[i]);
//	}
//
//	int[] p2 = new int[p.length];
//	int[] p3 = new int[p.length];
//	int cnt = 0;
//
//	while (!q.isEmpty()) {
//		int s = q.size();
//		int c = 0;
//		for (int i = 0; i < q.size(); i++) {
//			if (b[q.get(i)] != 0) {
//				p2[cnt++] = q.get(i);
//				b[q.get(i)]--;
//				p3[c++] = i;
//				i += b[q.get(i)];
//			}
//		}
//		for (int i = 0; i < c; i++) {
//			q.remove(p3[i]-i);
//		}
//	}
}
