package sw_expert._0129;
import java.util.Scanner;
import java.util.Stack;

public class 계산기3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;
			T=sc.nextInt();
			
			String expr = sc.next();
		
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder(); // 이어붙이고 수정하고 이어붙이고 수정하고 마지막에 완성된 string을 꺼냄
			
			for(int i=0; i<expr.length(); i++) {
				char c = expr.charAt(i);
				//피연산자면 그냥 출력한다.
				if(Character.isDigit(c))
					sb.append(c);//System.out.print(c);
				//연산자면
				else {
					//스택이 비었으면 그냥 push
					if(stack.isEmpty())
						stack.push(c);
					//덧셈이면, 스택이 빌 때까지 다 꺼내고 push
					else if(c == '+' || c == '-') {
						while(!stack.empty() && stack.peek() != '(')
							sb.append(stack.pop());//System.out.print(stack.pop());
						stack.push(c);
					}
					
					//곱셈이면, 스택이 비어있지 않으면서 맨 위에 덧셈이 나올때까지 다 꺼내고 push
					else if(c == '*' || c == '/') {
						while(!stack.empty() && stack.peek() != '+' && stack.peek() != '-' && stack.peek() != '(') {
							sb.append(stack.pop());//System.out.print(stack.pop());
						}
						stack.push(c);
					}
					//열림 괄호는 그냥 들어감
					else if(c == '(') {
						stack.push(c);
					}
					//열림 괄호를 만날 때 까지 다 꺼내서 출력하고, 열림 괄호는 버린다.
					else if(c == ')') {
						char top = stack.pop();
						while(!stack.empty() && top != '(') {
							sb.append(top);//System.out.println(top);
							top = stack.pop();
						}
					}
				}
			}
			while(!stack.empty())
				sb.append(stack.pop());//System.out.println(stack.pop());
			
			Stack<Integer> calStack = new Stack<>();
			
			//식을 순회하면서
			for(int i=0; i<sb.length(); i++) {
				char c =sb.charAt(i);
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
			System.out.println("#"+test_case + " " + calStack.pop());
		}
	}

}
