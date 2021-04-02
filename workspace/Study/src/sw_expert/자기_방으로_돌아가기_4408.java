package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 자기_방으로_돌아가기_4408 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			
			int N = sc.nextInt();
			
			int room[][] = new int [N][2];
			
			int max = 0;
			
			for(int i=0; i<N; i++) {
				room[i][0] = sc.nextInt();
				room[i][1] = sc.nextInt();
				max = Math.max(max, room[i][0]);
				max = Math.max(max, room[i][1]);
			}
			
			int check[] = new int[max+1];
			//boolean check2[] = new boolean[max+1];
			int result = 0;
			for(int i=0; i<N; i++) {
				int co1 = 0; int co2 =0;
				if(room[i][0] % 2== 0) {
					co1 = room[i][0] / 2;
				}
				else {
					co1 = room[i][0] /2 + 1;
				}
				
				if(room[i][1] % 2== 0) {
					co2 = room[i][1] / 2;
				}
				else {
					co2 = room[i][1] /2 + 1;
				}
				
				
				for(int j=Math.min(co1, co2); j<= Math.max(co1, co2); j++) {
					check[j]++;
				}
				
			}
			
			for(int i=0; i<check.length; i++) {
				if(result < check[i])
					result = check[i];
			}
			System.out.println(result);	
		}
	}
}
