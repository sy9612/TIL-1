package sw_expert;

import java.util.Scanner;

public class 건초더미_5603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			
			int N = sc.nextInt();
			
			int arr[] = new int[N];
			
			int result =0 ;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				result += arr[i];
			}
			
			result /= N;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				cnt += Math.abs(arr[i]-result);
			}
			
			System.out.println(cnt/2);
		}
	}

}
