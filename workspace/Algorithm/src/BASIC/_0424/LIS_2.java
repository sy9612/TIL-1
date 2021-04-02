package BASIC._0424;

import java.util.Arrays;

/**
 * LIS 최장 증가 수열 O[NlogN] 8 다음에 2가 올 경우 그냥 버리지 않고 LIS를 구성할 수 있는 위치에 저장
 *
 */
public class LIS_2 {
	public static void main(String[] args) {
		int[] a = { 8, 2, 4, 3, 6, 11, 7, 10, 14, 5 };
		int[] c = new int[a.length]; // LIS로 사용 가능한 숫자 저장, 2.index 저장
		int[] path = new int[a.length]; // 2.경로를 저장할 배열 역추적할 index 저장
		int size = 0; // LIS 개수 관리할 변수

//		c[size++] = a[0]; //1. 값저장
		path[size] = -1; //2. 첫번째 숫자라는 의미
		c[size++] = 0;//2. 인덱스 저장
		
		for (int i = 0; i < a.length; i++) {
			// c배열의 마지막 숫자와 수열 값 비교
			if (c[size - 1] < a[i]) {
//				c[size++] = a[i]; // 1. 값을 맨 뒤에 붙임
				path[i] = c[size-1]; //2. 가지고 있던 전의 값을 저장
				c[size++] = i; //2. 인덱스 저장
				
			} else { // LIS 마지막 숫자보다 크지 않으면 LIS의 값을 업데이트(이진 탐색)
				int temp = binarySearch0(a, c, 0, size, a[i]); // 삽입 할 위치 return
				if (temp < 0)
					temp = -temp - 1;
				//c[temp] = a[i]; // 1. 수열의 값을 LIS에 삽입할 위치에 덮어쓰기
				path[i] = path[c[temp]]; // 2. 덮어 쓸 위치의 index를 내껄로 복사
				c[temp] = i; // 2. 인덱스 저장
			}
		}
		//System.out.println(Arrays.toString(c) + " : C");
		System.out.println("LIS 개수: " + size);
		String result = "";
		for (int i = c[size-1];i != -1 ; i=path[i]) {
			result = a[i] + " "+result;
		}
		System.out.println("LIS 수열: " + result);
	}
	

	private static int binarySearch0(int[] a, int c[], int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1; // 중간값
			int midVal = a[c[mid]]; //a의 위치에서 수정

			if (midVal < key) //찾지 못할 경우가 더 많으므로 위쪽에 배치
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

}