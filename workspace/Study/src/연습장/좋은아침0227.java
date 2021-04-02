package 연습장;

import java.util.Arrays;

//최소공배수, 최대공약수
//next_permutation
public class 좋은아침0227 {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;

		int g = gcd(a, b);
		System.out.println("최대공약수: " + g);

		int l = a * b / g;
		System.out.println("최소공배수: " + l);

		// next_permutation
		int arr[] = { 1, 2, 3, 4 };
		Arrays.sort(arr); // 항상 순서대로
		System.out.println("배열: " + Arrays.toString(arr));
		next_permutation(arr);
		System.out.println("다음 순열: "+Arrays.toString(arr));

		prev_permutation(arr);
		System.out.println("이전 순열: "+ Arrays.toString(arr));
		
		System.out.println("모든 순열");
		do {
			System.out.println(Arrays.toString(arr));
		}while(next_permutation(arr));
	}

	private static boolean prev_permutation(int[] arr) {
		// 1243

		int idx = arr.length - 1; // 최대 인덱스
		// idx = 3;

		// arr[idx-1] <= arr[idx]일 때 반복
		// arr[idx-1] > arr[idx]이면 종료
		while (idx > 0 && arr[idx - 1] <= arr[idx])
			idx--;
		// idx = 3 (반복문 바로 탈출)
		// arr[idx-1] =4 > arr[idx] = 3

		if (idx <= 0)
			return false; // 다음 순열이 존재하지 않음

		int i = arr.length - 1;
		// i = 3

		// arr[idx-1] <= a[i]일 때 반복
		// arr[idx-1] > a[i]가 되면 종료
		while (arr[idx - 1] <= arr[i])
			i--;
		// arr[idx-1] = 4
		// arr[i] = 3
		// i = 3 (index기준)

		// idx=3, i =3
		// idx-1과 i를 바꿈
		swap(arr, idx - 1, i); // 두개를 바꿈

		// j=3
		int j = arr.length - 1;
		// 기준값의 위치 idx부터 뒤에 있는 숫자들을 바꿈
		while (idx < j) {
			// idx=3, j = 3
			// 바뀜 없이 바로 탈출
			swap(arr, idx, j);
			idx++;
			j--;
		}
		// 최종결과: 1243
		return true;
	}

	private static boolean next_permutation(int[] arr) {
		// 1234

		int idx = arr.length - 1; // 최대 인덱스
		// idx = 3;

		// arr[idx-1] >= arr[idx]일 때 반복
		// arr[idx-1] < arr[idx]이면 종료
		while (idx > 0 && arr[idx - 1] >= arr[idx])
			idx--;
		// idx = 3 (반복문 바로 탈출)
		// arr[idx-1] =3 < arr[idx] = 4

		if (idx <= 0)
			return false; // 다음 순열이 존재하지 않음

		int i = arr.length - 1;
		// i = 3

		// arr[idx-1] >= a[i]일 때 반복
		// arr[idx-1] < a[i]가 되면 종료
		while (arr[idx - 1] >= arr[i])
			i--;
		// arr[idx-1] = 3
		// arr[i] = 4
		// i = 3 (index기준)

		// idx=3, i =3
		// idx-1과 i를 바꿈
		swap(arr, idx - 1, i); // 두개를 바꿈

		// j=3
		int j = arr.length - 1;
		// 기준값의 위치 idx부터 뒤에 있는 숫자들을 바꿈
		while (idx < j) {
			// idx=3, j = 3
			// 바뀜 없이 바로 탈출
			swap(arr, idx, j);
			idx++;
			j--;
		}
		// 최종결과: 1243
		return true;

	}

	private static void swap(int[] arr, int idx, int i) {
		// TODO Auto-generated method stub
		int temp = arr[idx];
		arr[idx] = arr[i];
		arr[i] = temp;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
