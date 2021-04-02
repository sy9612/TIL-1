package 기출;

import java.util.*;

public class 이차원배열과연산_17140 {
	static int R;
	static int C;
	static int K;
	static int[][] A;
	static int min;

	static class Node {
		int number = 0;
		int size = 0;

		Node(int n, int s) {
			number = n;
			size = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		A = new int[101][101];
		min = 100000;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int r = 3;
		int c = 3;

		int t = 0;
		while (true) {
			if(t > 100) {
				System.out.println(-1);
				return;
			}
			if (A[R][C] == K) {
				System.out.println(t);
				return;
			}
			t++;
			// 행이 열보다 많을 때 행 정렬
			if (c >= r) {
				int m = 0;
				for (int i = 1; i <= c; i++) {
					Map<Integer, Integer> h = new HashMap<>();
					for (int j = 1; j <= r; j++) {
						if (A[i][j] != 0 && h.containsKey(A[i][j])) {
							h.replace(A[i][j], h.get(A[i][j]) + 1);
						} else if( A[i][j]!=0){
							h.put(A[i][j], 1);
						}
					}
					List<Map.Entry<Integer, Integer>> list = new LinkedList<>(h.entrySet());

					Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
						@Override
						public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
							if(o1.getValue() == o2.getValue()) {
								return o1.getKey().compareTo(o2.getKey());
							}
							else if(o1.getValue()< o2.getValue()) {
								return -1;
							}
							else
								return 1;
							
						}
					});
					
					Arrays.fill(A[i], 0);
					int bj = 1;
					for (int k = 0; k < list.size(); k++) {
						if(k > 100)
							break;
						A[i][bj++] = list.get(k).getKey();
						A[i][bj++] = list.get(k).getValue();
					}
					
					if(m < bj)
						m = bj;
				}
				r = m-1;
			}

			// 열 정렬
			else {
				int m =0;
				for (int i = 1; i <= r; i++) {
					Map<Integer, Integer> h = new HashMap<>();
					for (int j = 1; j <= c; j++) {
						if (A[j][i] != 0 && h.containsKey(A[j][i])) {
							h.replace(A[j][i], h.get(A[j][i]) + 1);
						} else if(A[j][i] != 0){
							h.put(A[j][i], 1);
						}
					}
					List<Map.Entry<Integer, Integer>> list = new LinkedList<>(h.entrySet());

					Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
						@Override
						public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
							if(o1.getValue() == o2.getValue()) {
								return o1.getKey().compareTo(o2.getKey());
							}
							else if(o1.getValue()< o2.getValue()) {
								return -1;
							}
							else
								return 1;
							
						}
					});
					
					for(int k=1; k<=c; k++) {
						A[k][i] = 0;
					}
					
					int bi = 1;
					for (int k = 0; k < list.size(); k++) {
						if(k>100)
							break;
						A[bi++][i] = list.get(k).getKey();
						A[bi++][i] = list.get(k).getValue();
					}
					if(m < bi)
						m = bi;
				}
				c = m-1;
			}
		}
	}
}
