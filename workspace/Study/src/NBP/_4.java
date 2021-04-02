package NBP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _4 {
	public static void main(String[] args) {
		int n = 2;
		int capacity = 5;
		int[] files = { 1, 2, 3, 4, 5 };
		System.out.println(solution(n, capacity, files));
	}

	public static int solution(int n, int capacity, int[] files) {
		int answer = 0;
		LinkedList<Queue<Integer>> ql = new LinkedList<>();

	      for (int i = 0; i < (1 << files.length); i++) {
	         LinkedList<Integer> q = new LinkedList<>();
	         for (int j = 0; j < files.length; j++)
	            q.add(files[j]);

	         for (int z = 0; z < n; z++) {

	            int sum = 0;
	            for (int j = 0; j < q.size(); j++) {
	               if ((i & (1 << j)) != 0) {
	                  // j번째 원소 선택
	                  sum += q.get(j);
	               }
	            }

	            int[] a = new int[q.size()];
	            int c = 0;
	            if (sum <= capacity) {
	               Queue<Integer> b = new LinkedList<>();
	               for (int j = 0; j < q.size(); j++) {
	                  if ((i & (1 << j)) != 0) {
	                     int bb = q.get(j);
	                     b.add(bb);
	                     System.out.print(q.get(j));
	                     a[c++] = j;
	                  }
	               }

	               System.out.println();

	               for (int j = 0; j < c; j++) {
	                  q.remove(a[j] - j);
	               }
	               ql.add(b);
	            }
	         }
	         
	      }
		return answer;
	}
	

}
