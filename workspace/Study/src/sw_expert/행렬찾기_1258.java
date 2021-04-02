package sw_expert;

import java.util.*;

public class 행렬찾기_1258 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int n = sc.nextInt();
			int arr[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int result[][] = new int[n][2];
			int rc = 0;
			boolean check[][] = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] != 0) {
						int x =0; int y =0;
						for(int k=i; k<n; k++) {
							if(arr[k][j] == 0)
								break;
							x++;
						}
						for(int k=j; k<n; k++) {
							if(arr[i][k] == 0) 
								break;
							y++;
						}
						if(check[i+x-1][j+y-1] == false) {
							check[i+x-1][j+y-1] = true;
							result[rc][0] = x;
							result[rc][1] = y;
							rc++;
						}
					}
				}
			}
			
			for(int i=0; i<rc; i++) {
				for(int j=0; j<rc-(i+1); j++) {
					if((result[j][0]*result[j][1])>(result[j+1][0]*result[j+1][1])) {
						int tmp = result[j][0];
						result[j][0] = result[j+1][0];
						result[j+1][0] = tmp;
						
						tmp = result[j][1];
						result[j][1] = result[j+1][1];
						result[j+1][1] = tmp;
					}
					else if((result[j][0]*result[j][1])==(result[j+1][0]*result[j+1][1])) {
						if(result[j][0] >result[j+1][0]) {
							int tmp = result[j][0];
							result[j][0] = result[j+1][0];
							result[j+1][0] = tmp;
							
							tmp = result[j][1];
							result[j][1] = result[j+1][1];
							result[j+1][1] = tmp;
						}
					}
				}
			}

			System.out.print(rc + " ");
			
			for(int i=0; i<rc; i++) {
				System.out.print(result[i][0] + " " + result[i][1]+ " ");
			}
			System.out.println();
		}
	}
}
