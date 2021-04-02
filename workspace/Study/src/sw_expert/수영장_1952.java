package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 수영장_1952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			 D = sc.nextInt();
			 M = sc.nextInt();
			 MM = sc.nextInt();
			 min = sc.nextInt();
			
			 swim = new int[12];
			
			for(int i=0 ;i<12; i++) {
				swim[i] = sc.nextInt();
			}
			
			dfs(0, 0);
			System.out.println(min);
		}
	}
	static int D;
	static int M;
	static int MM;
	static int min;
	static int swim[];
	private static void dfs(int idx, int sum) {
		if(idx >= 12)
		{
			if(min > sum)
				min = sum;
			return;
		}
		
		//하루
		dfs(idx+1, sum+swim[idx]*D);
		
		//한달
		dfs(idx+1, sum+M);
		
		//3달
		dfs(idx+3, sum+MM);
		
	}
	
	
}
