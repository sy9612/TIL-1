package BASIC._0121.Practice;

import java.util.Arrays;

public class Baby_jin_Solution {
	public static void main(String[] args) {

		int[] arr = {1,2,3,1,2,3};
		int[] cnt = new int[10];
		for(int i=0; i<arr.length; i++) {
			cnt[arr[i]]++;
		}
		
		int result = 0; 
		for(int i=0; i<10; i++) {
		
			if(cnt[i] >= 3) {
				cnt[i] -= 3;
				result++;
				
				i--;
				continue;
			}
		
			if(i <= 7 && cnt[i] >= 1 && cnt[i+1] >=1 && cnt[i+2] >=1) {
				cnt[i]--;
				cnt[i+1]--;
				cnt[i+2]--;
				result++;
				i--;
				continue;
			}
		}
		if(result == 2)
			System.out.println("���̺��� �����մϴ�.");
		
		//boolean result = isBabygin(arr);
		//System.out.println(result ? "���̺����Դϴ�" : "���̺����� �ƴմϴ�.");
	}

	static boolean isBabygin(int[] arr) {
		int[] front = Arrays.copyOfRange(arr, 0, 3);
		int[] back = Arrays.copyOfRange(arr, 3, 6);

		boolean frontOk = isTriplet(front) || isRun(front);
		boolean backOk = isTriplet(back) || isRun(back);

		return frontOk && backOk;
	}

	static boolean isTriplet(int[] arr) {
		if (arr[0] == arr[1] && arr[1] == arr[2])
			return true;
		return false;
	}

	static boolean isRun(int[] arr) {
		if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2])
			return true;
		return false;
	}
}
