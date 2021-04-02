package naver;

public class _1 {
	
	public static void main(String[] args) {
		int n = 6;
		int[] p = 
			//{6, 2, 1, 0, 2, 4, 3};
				{5, 4, 7, 2, 0, 6};
		int[] c = {4, 6, 4, 9, 2, 3};
			//{3, 6, 6, 2, 3, 7, 6};
		
		solution(n, p, c);
	}
	public static String solution(int n, int[] p, int[] c) {
		String answer = "";
		
		
		//yes == 0, 100원
		//yes == 1, 50원
		//yes == 2, 25원
		//yes == 3, 거래중지
		
		int yes = 100;
		int ball = 0;
		double ans = 0;
		int cnt = n-1;
		
		for (int i = 0; i < n; i++) {
			ball += p[i];
			
			if(ball >= c[i])
			{
				ball -= c[i];
				ans += c[i] * yes;
				yes = 100;
			}
			
			else if(ball < c[i]) {
				if(yes % 2 != 0) {
					//거래 중지
					cnt = i;
					break;
				}
				else {
					yes /= 2;
				}
			}
		}
		
		answer = String.format("%.2f", ans/(cnt+1));
		
		System.out.println(answer);
		return answer;
	}
}
