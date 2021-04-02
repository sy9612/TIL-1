package BASIC._0128;

import java.util.Arrays;

public class 중복순열 {
	static int[] arr = {2,4,6};
	static int[] result = new int[arr.length];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rePerm(0);
	}
	
	static void rePerm(int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		/*		
		result[idx] = arr[0];
		rePerm(idx+1);
		result[idx] = arr[1];
		rePerm(idx+1);
		result[idx] = arr[2];
		rePerm(idx+1);
		*/
		for(int i=0; i<arr.length; i++) {
			result[idx] = arr[i];
			rePerm(idx+1);
		}
		
	}
}
