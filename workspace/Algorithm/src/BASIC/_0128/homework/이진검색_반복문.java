package BASIC._0128.homework;

public class 이진검색_반복문 {
	static int arr[] = {1,3,5,7,9};
	static int target = 2;
	
	public static void main(String[] args) {
		
		int first = 0;
		int last = arr.length;
		
		while(true) {
			if(first>last)
			{
				System.out.println("FALSE");
				break;
			}
			int mid = (first+last)/2;
			if(arr[mid] == target)
			{
				System.out.println("Idx: "+mid);
				break;
			}
			else if(arr[mid]>target) {
				last = mid-1;
			}
			else {
				first = mid+1;
			}
			
		}

	}

}
