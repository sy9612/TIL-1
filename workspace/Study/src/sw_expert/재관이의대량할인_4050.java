package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 재관이의대량할인_4050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int cloth[] = new int[N];
			int result = 0;
			
			for (int i = 0; i < cloth.length; i++) {
				cloth[i] = sc.nextInt();
				result += cloth[i];
			}
			
			Arrays.sort(cloth);
			
			for (int i = N-3; i >=0; i-=3) {
				result -= cloth[i];
			}
			
			System.out.println(result);
			
		}
		sc.close();
	}
	
}
