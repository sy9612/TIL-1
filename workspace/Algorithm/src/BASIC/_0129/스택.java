package BASIC._0129;

import java.util.Scanner;

public class 스택 {

	public static void main(String[] args) {
		int[] stack = new int[5];
		int top = -1;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1. Push(입력 예: 1 10) \n2. Pop(입력 예: 2)\n0. 종료");
			int sel = sc.nextInt();
			if(sel == 0)
				break;
			else if(sel == 1) {
				// 스택이 꽉 찼는데 push를 하면 overflowException
				if(top+1>=stack.length) {
					System.out.println("StackOverflowException");
					continue;
				}
				int num = sc.nextInt();
				System.out.println(num + "을 push");
				top++;
				stack[top] = num;
			}
			else if(sel == 2) {
				// 스택에 아무것도 없는데 pop을 하면 emptystackException
				if(top == -1) {
					System.out.println("EmptyStackException");
					continue;
				}
				System.out.println("pop 되는 값을 출력");
				System.out.println(stack[top]);
				top--;
			}
		}

	}
}
