package 연습장;

import java.util.Arrays;

public class 좋은아침0225 {
	static char[] arr = {'1','2','1'};
	public static void main(String[] args) {
		//부분집합
		
		for(int i=0; i<(1<<arr.length); i++) {
			for(int j=0; j<arr.length; j++) {
				if( (i&(1<<j)) != 0) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
		System.out.println("-----------------");
		//조합
//		comb(0,0);
		System.out.println("-----------------");
		//중복조합
//		recomb(0,0);
		System.out.println("-----------------");
		//순열
//		perm(0);
//		System.out.println(cnt);
		System.out.println("-----------------");
		//중복순열
		reperm(0);
		
		
	}
	static char[] represult = new char[arr.length];
	private static void reperm(int idx) {
		if(idx == represult.length) {
			System.out.println(Arrays.toString(represult));
			return;
		}
		for(int i=0; i<arr.length; i++) {
				represult[idx] = arr[i];
				reperm(idx+1);
			
		}
		
	}
	static char[] presult = new char[arr.length];
	static boolean[] visited = new boolean[presult.length];
	private static void perm(int idx) {
		if(idx == presult.length) {
			cnt++;
			System.out.println(Arrays.toString(presult));
			
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				presult[idx] = arr[i];
				visited[i] = true;
				perm(idx+1);
				visited[i] = false;
			}
		}
	}
	static char[] result = new char[2];
	private static void comb(int idx, int sidx) {
		// TODO Auto-generated method stub
		if(sidx == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(idx == arr.length)
			return;
		
		result[sidx] = arr[idx];
		comb(idx+1,sidx+1);
		comb(idx+1, sidx);
	}
	
	static int cnt = 0;
	static char[] reresult = new char[2];
	private static void recomb(int idx, int sidx) {
		// TODO Auto-generated method stub
		if(sidx == reresult.length) {
			System.out.println(Arrays.toString(reresult));
			return;
		}
		if(idx == arr.length)
			return;
		
		reresult[sidx] = arr[idx];
		recomb(idx,sidx+1);
		recomb(idx+1, sidx);
	}
}

