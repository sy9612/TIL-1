package 이것이코딩테스트다;
import java.util.Arrays;
import java.util.Scanner;

public class 부품찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		
		Arrays.sort(arr);
		
		for (int i = 0; i < M; i++) {
			int buf = sc.nextInt();
			
			int left = 0;
			int right = N-1;
			
			boolean ok = false;
			
			// ����Ž��
			while(left <= right) {
				int mid = (left+right)/2;
				
				if(arr[mid] == buf) {
					ok = true;
					System.out.println("yes");
					break;
				}
				
				if(arr[mid] > buf) {
					right = mid-1;
					
				}
				
				else if(arr[mid] < buf) {
					left = mid+1;
				}
			}
			
			if(!ok)
				System.out.println("no");
			
		}
		
		
	
		
		
		
	}
}
