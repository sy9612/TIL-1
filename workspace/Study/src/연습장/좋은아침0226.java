package 연습장;

import java.util.Arrays;

public class 좋은아침0226 {
	static char[] arr = {'A','B','C'};
	static char[] result = new char[2];
	//부분집합 순열 조합 중복순열 중복조합
	public static void main(String[] args) {
		//부분집합
		powerset(0);
		System.out.println("----------");
		//조합
		comb(0,0);
		System.out.println("----------");
		//중복조합
		recomb(0,0);
		System.out.println("----------");
		//순열
		perm(0);
		System.out.println("----------");
		//중복순열
		reperm(0);
	}
	static boolean[] sel = new boolean[arr.length];
	private static void powerset(int idx) {
		// TODO Auto-generated method stub
		if(idx == arr.length) {
			for(int i=0; i<sel.length; i++) {
				if(sel[i])
					System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
	private static void reperm(int idx) {
		// TODO Auto-generated method stub
		if(idx == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
				result[idx] = arr[i];
				perm(idx+1);
		}
	}
	static boolean visited[] = new boolean[arr.length];
	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if(idx == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				perm(idx+1);
				visited[i] = false;
			}
		}
	}
	private static void recomb(int idx, int sidx) {
		if(sidx == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(idx == arr.length)
			return;
		
		result[sidx] = arr[idx];
		recomb(idx, sidx+1);
		recomb(idx+1, sidx);
	}
	private static void comb(int idx, int sidx) {
		if(sidx == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(idx == arr.length)
			return;
		
		result[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}

}
