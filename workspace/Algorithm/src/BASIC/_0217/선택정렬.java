package BASIC._0217;

import java.util.Arrays;

public class 선택정렬 {
	static int arr[] = {5,4,2,3,7,1,8};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SelectionSort(arr, 0, 1, 0);
		System.out.println(Arrays.toString(arr));
		
	}

	//Solution
	static void sort(int idx) {
		if( idx == arr.length )
			return;
		int min, tmp;
		min = idx;
		for(int i = idx; i < arr.length; i++) {
			if( arr[i] < arr[min] )
				min = i;
		}
		tmp = arr[min];
		arr[min] = arr[idx];
		arr[idx] = tmp;
		sort(idx + 1);
	}
	
	private static void SelectionSort(int[] arr, int min, int cnt, int s) {

		if(s == arr.length-1) {
			return;
		}
		
		if(cnt == arr.length) {
			int tmp = arr[min];
			arr[min] = arr[s];
			arr[s] = tmp;
			
			SelectionSort(arr,arr[s],s+2,s+1);
			return;
			
		}
		
		if(arr[cnt] < arr[min])
			SelectionSort(arr,cnt,cnt+1,s);
		else
			SelectionSort(arr,min,cnt+1,s);
		
	}

}
