package NBP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _3 {
	public static void main(String[] args) {
		int[] arr = {3,2,1,4,5};
			//{ 2, 1, 3, 1, 4, 2, 1, 3 };
		solution(arr);
	}

	public static int solution(int[] p) {
		int answer = 0;


		int[] b = new int[1000001];
		Arrays.sort(p);
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < p.length; i++) {
			b[p[i]]++;
			q.add(p[i]);
		}
	
		int[] p3 = new int[p.length];
		int cnt = 0;
	
		int r = 0;
		while (!q.isEmpty()) {
			int s = q.size();
			int c = 0;
			for (int i = 0; i < q.size(); i++) {
				if (b[q.get(i)] != 0) {
					b[q.get(i)]--;
					p3[c++] = i;
					i += b[q.get(i)];
					r++;
				}
			}
			for (int i = 0; i < c; i++) {
				q.remove(p3[i]-i);
			}
			r--;
		}
		
		return r;
	}
	
}
