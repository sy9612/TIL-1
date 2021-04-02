package chap02;

import java.util.Arrays;

public class Main02 {
	public static void main(String[] args) {
		int[][]arr = new int[2][3];
		int[][]arr2 = { {1,3,5}, {2,4,8}};
		int[][]arr3 = new int[][] {{1,3,5}, {2,4,8}};
		
		for (int r = 0; r < arr2.length; r++) {
			for (int c = 0; c < arr2[r].length; c++) {
				System.out.print(arr2[r][c]+ " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		Lotto[][] lrr = new Lotto[2][2];
		lrr[0][0] = new Lotto();
		lrr[0][1] = new Lotto();
		lrr[1][0] = new Lotto();
		lrr[1][1] = new Lotto();
	
		System.out.println(lrr[0][0].toString());
	}
}
