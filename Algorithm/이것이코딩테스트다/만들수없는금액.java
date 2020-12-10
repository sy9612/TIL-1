package 이것이코딩테스트다;

import java.util.Arrays;
import java.util.Scanner;
/**
 * N개의 개수만큼 숫자가 주어졌을 때, 만들 수 없는 최소 숫자 찾기
 * sort 후 앞에서부터 숫자를 더해서 target 설정
 * @author 15com
 *
 */
public class 만들수없는금액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int target = 1;
		for (int i = 0; i < arr.length; i++) {
			if( target < arr[i]) {
				break;
			}
			target += arr[i];
		}
		 
		System.out.println(target);
	}

	
}
 
