package sw_expert.Solution;

import java.util.Scanner;

public class 자기_방으로_돌아가기_4408_Soultion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			
			int[] hall = new int[401];
			int N = sc.nextInt();
			for(int i= 0; i<N; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if(from > to)
				{
					int tmp = from;
					from =to;
					to = tmp;
				}
				
				if(from%2 ==1)from++;
				if(to%2 == 1) to++;
				
				for(int j = from; j<= to; j++)
					hall[j] ++;
			}
			
			int Ans = 0;
			for(int i= 1; i <400; i++)
				Ans = Math.max(Ans,  hall[i]);
			
			System.out.println(Ans);
		}
	}

}
