package NBP;

import java.util.Arrays;

public class _1 {
	public static void main(String[] args) {
		int[] arrA = { 7, 8, 10 };
		int[] arrB = { 10, 7, 8 };
		System.out.println(solution(arrA, arrB));
	}

	public static boolean solution(int[] arrA, int[] arrB) {
		boolean answer = false;

		for (int j = 0; j < arrA.length; j++) {

			int tmp = arrA[arrA.length - 1];
			for (int i = arrA.length - 1; i >= 1; i--) {
				arrA[i] = arrA[i - 1];
			}
			arrA[0] = tmp;
			
			if(Arrays.equals(arrA, arrB)) {
				answer = true;
				break;
			}
		}

		return answer;
	}
}
