package sw_expert._0129;
import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기_자르기_Stack_Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
				
			int result = 0; //결과를 저장할 변수
			Stack<Character> stack = new Stack<>();
			
			String str = sc.next();
			//한 글자씩 검사
			for(int i=0; i<str.length(); i++) {
				//열림 괄호라면, 누적막대기 1 증가
				if(str.charAt(i) == '(')
					stack.push('(');
				//닫힘 괄호라면,
				else if(str.charAt(i) ==')')
				{
					//닫힘을 만나면 레이저이든, 막대기의 종료이든, 한 조각의 막대기는 사라지는 것
					char c = stack.pop();
					//직전에 열림이었다면, 누적막대기만큼 결과에 합함
					if(str.charAt(i-1) == '(')
						result += stack.size();
					//직전에 닫힘이었다면, 결과+1
					else if(str.charAt(i-1)==')') {
						result++;						
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			
		}
	}
}
