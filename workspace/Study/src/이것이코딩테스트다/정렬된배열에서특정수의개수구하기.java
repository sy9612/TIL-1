package 이것이코딩테스트다;
import java.util.ArrayList;
import java.util.Scanner;

public class 정렬된배열에서특정수의개수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = sc.nextInt();
	
		// 1안
		// inout 시간으로 인해 시간초과가 발생 할 수 있음
	
//		ArrayList<Integer> arr = new ArrayList<>();
//		
//		for (int i = 0; i < N; i++) {
//			arr.add( sc.nextInt() );
//		}
		
		
//		int left = 0;
//		int right = N-1;
//		int result = 0;
//		while(left<=right) {
//			int mid = (left+right)/2;
//			
//			if(arr.get(mid) == x) {
//				result++;
//				arr.remove(mid);
//				continue;
//			}
//
//			if(arr.get(mid) < x) {
//				left = mid +1;
//			}
//			else if(arr.get(mid) > x) {
//				
//				right = mid-1;
//			}
//		}
		
		//2안
		//같은 개수가 있는 시작과 끝점 새기
		int[] arr = new int[N];
		int first = -1;
		int end = -1;
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == x) {
				if(first == -1)
					first = i;
				end = i;
			}
		}
		
		result = end - first + 1;
		
		
		System.out.println(result);
	}
}
