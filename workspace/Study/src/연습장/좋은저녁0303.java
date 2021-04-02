package 연습장;

import java.util.Arrays;

//최소공배수 최대공약수
public class 좋은저녁0303 {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		
		int g = gcd(a, b);
		int l = a * b /g;
		
		System.out.println("최대공약수: " + g + " 최소공배수: "+l);
		
		int[] arr = {1,2,3,4};
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(next_permutation(arr));
	}

	private static boolean next_permutation(int[] arr) {
		int i = arr.length-1;
		
		while(i>0 && arr[i-1]>= arr[i]) i--;

		if(i<=0)
			return false;
		
		int j =arr.length-1;
		while(arr[i-1]>= arr[j]) j--;
		
		swap(arr,i-1,j);
		
		int k = arr.length-1;
		
		while(i < k) {
			swap(arr,i,k);
			i++;k--;
		}
		
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
