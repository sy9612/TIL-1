package 연습장;

import java.util.Arrays;

//세준's 좋은아침
//부분집합 순열 조합 중복순열 중복조합
public class 좋은아침0224 {
	static char arr[] = { 'A', 'B', 'C' };

	public static void main(String[] args) {
		// 부분집합
		for (int i = 0; i < (1 << arr.length); i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((i & 1 << j) != 0)
					System.out.print(arr[j]);
			}
			System.out.println();
		}

		// 조합
		System.out.println("------------조합------------");
		comb(0, 0);
		// 순열
		System.out.println("------------순열------------");
		perm(0);
		// 중복조합
		System.out.println("------------중복조합------------");
		jcomb(0,0);
		// 중복순열
		System.out.println("------------중복순열------------");
		jperm(0);
	}
	/*다시외우기 중복조합*/
	static char[] jresult = new char[2];
	private static void jcomb(int idx,int r) {
		if(r == jresult.length) {
			System.out.println(Arrays.toString(jresult));
			return;
		}
		if(idx == arr.length) return;
		jresult[r] = arr[idx];
		jcomb(idx, r+1);
		jcomb( idx+1, r);
	}

	private static void jperm(int idx) {
		// TODO Auto-generated method stub
		if (idx == presult.length) {
			System.out.println(Arrays.toString(presult));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			presult[idx] = arr[i];
			jperm(idx + 1);
		}
	}

	static char[] presult = new char[2];
	static boolean[] visited = new boolean[arr.length];

	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if (idx == presult.length) {
			System.out.println(Arrays.toString(presult));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				presult[idx] = arr[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}

	static char[] cresult = new char[2];

	private static void comb(int idx, int s_idx) {
		if (s_idx == cresult.length) {
			System.out.println(Arrays.toString(cresult));
			return;
		}

		if (idx == arr.length) {
			return;
		}

		cresult[s_idx] = arr[idx];
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}

}
