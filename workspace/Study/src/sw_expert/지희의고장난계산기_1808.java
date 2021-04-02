package sw_expert;

import java.util.*;

public class 지희의고장난계산기_1808 {
	static ArrayList<String> re;
	static int X;
	static int cal[];
	static int cnt;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			 cal = new int[10];
			 min = 9999999;
			 cnt = 0;
			for (int i = 0; i < 10; i++) {
				int buf = sc.nextInt();
				if (buf == 1) {
					cal[cnt++] = i;
				}
			}
			X = sc.nextInt();
			int i;
			if(cal[0] == 0)
				i = 1;
			else i = 0;
			for(;i<cnt; i++)
				dfs(cal[i],cal[i],0);
			if(min == 9999999)
				System.out.println(-1);
			else System.out.println(min);
		}
	}

	private static void dfs(int idx, int mul, int count) {
		if(mul == X) {
			if(min > count)
				min = count;
			return;
		}
		
		for(int i=0; i<cnt; i++) {
			String buf = ""+idx;
			buf += ""+cal[i];
			if(Integer.parseInt(buf)<= X) {
				dfs(Integer.parseInt(buf),mul, count+1);
			}
			if(cal[i] != 0 && cal[i] != 1 && mul * cal[i] <= X) {
				dfs(cal[i], mul*cal[i], count+2);
			}
		}
	}
	

}
