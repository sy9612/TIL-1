package BASIC._0217;

import java.util.Arrays;

public class 순열_최소한의변경 {
	static int[] arr = {1,2,3};
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int idx) {
		//idx가 배열의 크기인 3이 되면 순열이 뽑힌것
		if( idx == arr.length ) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		//idx부터 마지막 원소까지 반복 하며
		for(int i = idx; i < arr.length; i++) {
			swap(idx, i);
			perm(idx + 1);
			swap(idx, i);
		}
	}
	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;;
	}
}
