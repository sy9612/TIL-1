package sw_expert;

import java.util.Scanner;

public class 조만들기_8104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			System.out.print("#" + tc + " ");
		
			int result[] = new int[N*K+1];
			
			for(int i=1; i<N*K+1;) {
				int cnt = 1;
				
				for(int j =0; j<K; j++,i++) {
					result[cnt++] += i;
				}
				cnt--;
				if(i > N*K)
					break;
				for(int k=0; k<K; k++, i++) {
					result[cnt--] += i;
				}
								
			}
			
			for(int i=1;i <K+1; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}

}
