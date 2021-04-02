package coupang;

public class _1 {
	public static void main(String[] args) {
		solution(14);
	}
	public static int[] solution(int N) {
	
		
		int max = 0;
		int sn = 0;
		for (int i = 2; i < 10; i++) {
			String sb = "";
			int num = N;
			
			while(num>0) {
				sb = (num % i) + sb;
				num /= i;
			}
			
			int p = 1;
			for (int j = 0; j < sb.length(); j++) {
				if(sb.charAt(j) != '0') {
					p *= sb.charAt(j) - '0';
				}
			}
			
			if(max <= p) {
				max = p;
				sn = i;
			}
		}
		
		int[] answer = new int[2];
		
		answer[0] = sn;
		answer[1] = max;
		
		System.out.println(sn);
		System.out.println(max);
		return answer;
	}
}
