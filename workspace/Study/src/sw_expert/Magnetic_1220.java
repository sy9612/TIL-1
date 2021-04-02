package sw_expert;

import java.util.Scanner;

public class Magnetic_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			int arr[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[j][i] == 1) {
						
					}
				}
			}
		}
	}

}
