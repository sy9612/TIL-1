package BASIC._0129;

import java.util.Stack;

public class 괄호검사 {
	public static void main(String[] args) {
		// (과 )는 아스키코드값이 1 차이
		String str = "((()((((()()((()())((())))))";
		Stack<Character> stack = new Stack<>();
		
		boolean result = true;
		//Sring에서 한글자 씩 탐색
		for(int i=0; i<str.length(); i++) {
			//해당 문자를 스택에 담음
			if(str.charAt(i) == '(') {
				stack.push('(');
			}
			//스택에서 pop해서 짝꿍인지 검사
			else if(str.charAt(i) == ')') {
				//스택이 비어있지 않은 경우 검사
				if(!stack.isEmpty() && stack.pop() != '(') {
					result = false;
					break;
				}
			}
		}
		
		if(result) {
			if(!stack.isEmpty())
				System.out.println("잘못됨");			
			else
				System.out.println("정상");
		}
		else {
			System.out.println("잘못됨");
		}
	}
}
