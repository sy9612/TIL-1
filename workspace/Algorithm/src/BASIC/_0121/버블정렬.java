package BASIC._0121;

import java.util.Arrays;

public class  버블정렬 {
	public static void main(String[] args) {

		int[] arr = { 6, 7, 2, 5, 1, 8 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}
