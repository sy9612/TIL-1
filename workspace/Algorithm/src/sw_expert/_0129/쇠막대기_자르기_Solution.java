package sw_expert._0129;

import java.util.Scanner;

public class 쇠막대기_자르기_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
				
			int result = 0; //결과를 저장할 변수
			int stick = 0; //누적막대기의 갯수
			
			String str = sc.next();
			//한 글자씩 검사
			for(int i=0; i<str.length(); i++) {
				//열림 괄호라면, 누적막대기 1 증가
				if(str.charAt(i) == '(')
					stick++;
				//닫힘 괄호라면,
				else if(str.charAt(i) ==')')
				{
					//닫힘을 만나면 레이저이든, 막대기의 종료이든, 한 조각의 막대기는 사라지는 것
					stick--;
					//직전에 열림이었다면, 누적막대기만큼 결과에 합함
					if(str.charAt(i-1) == '(')
						result += stick;
					//직전에 닫힘이었다면, 결과+1
					else if(str.charAt(i-1)==')')
						result++;
				}
			}
			
			System.out.println("#"+tc+" "+result);
			
		}
	}

}
