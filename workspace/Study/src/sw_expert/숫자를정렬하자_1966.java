package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자를정렬하자_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-i-1; j++) {
					if(arr[j] > arr[j+1])
					{
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			for(int i=0; i<N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		
	}

}
