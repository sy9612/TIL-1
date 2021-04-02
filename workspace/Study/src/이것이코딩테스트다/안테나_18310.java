package 이것이코딩테스트다;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class 안테나_18310 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		System.out.println(arr[ (N-1)/2]);
	}
}
