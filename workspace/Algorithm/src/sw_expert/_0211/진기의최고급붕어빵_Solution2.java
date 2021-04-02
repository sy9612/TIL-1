package sw_expert._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<= T; tc++) {
			int N, M, K;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			int[] persons = new int[N];
			for(int i=0; i<N; i++)
				persons[i] = sc.nextInt();
			Arrays.sort(persons);
			boolean isOk = true;
			for(int i=0; i<N;i++) {
				int myBread = persons[i] / M * K - i;
				if(myBread<= 0) {
					isOk =false;
					break;
				}
			}

			System.out.println("#" + tc + " "+ (isOk?"Possible":"Impossible"));
		}
	}
}
