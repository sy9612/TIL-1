package BASIC._0121;

public class 삽입정렬 {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 6, 3, 8, 7, 9 };

		for (int j = 0; j < arr.length; j++) {

			int min = arr[j];
			int index = j;

			for (int i = j + 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					index = i;
				}
			}

			int temp = arr[j];
			arr[j] = arr[index];
			arr[index] = temp;

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
