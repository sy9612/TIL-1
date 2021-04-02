package BASIC._0129;

import java.util.Stack;

public class 후위표기연산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "6528-*2/+";
		Stack<Integer> calStack = new Stack<>();
		
		//식을 순회하면서
		for(int i=0; i<str.length(); i++) {
			char c =str.charAt(i);
			//피연산자면 스택에 담는다.
			if( Character.isDigit(c)) {
				calStack.add(c-'0');
			}
			//연산자면, 스택에서 두개 꺼내서 해당 연산 후 결과를 스택에 담는다.
			else {
				int num2 = calStack.pop();
				int num1 = calStack.pop();
				switch(c) {
				case '+':
					calStack.push(num1+num2);
					break;
				case '-':
					calStack.push(num1-num2);
					break;
				case '*':
					calStack.push(num1*num2);
					break;
				case '/':
					calStack.push(num1/num2);
					break;
				}
			}
		}
		
		//식이 끝난 후
		//스택에 들어있는 그 하나의 숫자가 정답!
		System.out.println(calStack.pop());
	}
}
