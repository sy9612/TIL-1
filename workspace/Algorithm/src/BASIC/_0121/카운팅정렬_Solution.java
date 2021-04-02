package BASIC._0121;

import java.util.Arrays;

public class 카운팅정렬_Solution {
	public static void main(String[] args) {
		int[] arr = {3,1,0,4,5,2,3,7};
		
		int[] count = new int[8];
		for(int i=0; i<arr.length; i++)
			count[ arr[i]]++;
		for(int i=1; i<arr.length; i++) {
			count[i] += count[i-1];
		}
		int[] sorted_arr = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sorted_arr[ --count[ arr[i] ] ] = arr[i];
		}
		System.out.println(Arrays.toString(sorted_arr));
	}

}
