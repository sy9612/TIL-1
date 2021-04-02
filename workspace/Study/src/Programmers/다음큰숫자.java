package Programmers;

public class 다음큰숫자 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));

	}

	public static int solution(int n) {
		int answer = 0;
		
		int ncnt = one_count(n);
		
		while(true) {
			if(one_count(++n) == ncnt) {
				System.out.println(n);
				answer = n;
				break;
			}
		}
		

		return answer;
	}

	private static int one_count(int n) {
		// TODO Auto-generated method stub
		
		int cnt = 0;
		while(n != 0) {
			if(n%2 == 1)cnt++;
			n /= 2;
		}
		
		return cnt;
		
	}
	
	
	
}
