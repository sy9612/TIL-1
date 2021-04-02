package BASIC._0128.homework;

public class 이진검색_재귀함수 {
	static int arr[] = {1,3,5,7,9};
	static int target = 2;
	
	public static void main(String[] args) {
		BinarySearch_cur(0, arr.length);			
	}
	static void BinarySearch_cur(int first, int last) {
		if(first > last) {
			System.out.println("FALSE");
			return;
		}
		int mid = (first + last) / 2;
			
		if(arr[mid] == target) {
			System.out.println("Idx: "+ mid);
			return;
		}
		else if(arr[mid] > target)
			BinarySearch_cur(first,mid-1);
		else if(arr[mid] < target)
			BinarySearch_cur(mid+1,last);
		
	}
}
