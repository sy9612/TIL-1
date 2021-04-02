package 연습장;

import java.util.Arrays;

//최대공약수 최소공배수 다음순열
public class 좋은아침0302 {
	public static void main(String[] args) {
		int a = 150;
		int b = 190;
		
		int g = gcd(a,b);
		int m = a*b /g;
		
		System.out.println("최대공약수: " + g + " 최소공배수: " + m);
		
		int[] arr = { 1, 2, 3, 4};
		
		do{
			System.out.println(Arrays.toString(arr));
		}while(next_perm(arr));
	}

	private static boolean next_perm(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		
		if( i<=0)
			return false;
		int j= arr.length-1;
		
		while(arr[i-1] >= arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k = arr.length - 1;
		
		while(i < k) {
			swap(arr,i,k);
			i++; k--;

		}
		return true;
	}
	private static void swap(int[] arr, int idx, int i) {
		// TODO Auto-generated method stub
		int temp = arr[idx];
		arr[idx] = arr[i];
		arr[i] = temp;
	}
	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
