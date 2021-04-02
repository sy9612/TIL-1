package kakaotest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class _2 {
	public static void main(String[] args) {

		String a = "50*6-3*2";
		long answer = solution(a);
		System.out.println(answer);
	}

	static char sy[];
	static char sel[];

	static boolean[] visited;
	static char[][] s;
	static int c = 0;

	static void perm(int idx) {

		if (idx == sy.length) {
			for (int i = 0; i < sel.length; i++) {
				s[c][i] = sel[i];
			}
			c++;
			return;
		}

		for (int i = 0; i < sy.length; i++) {
			// i번째가 아직 고르지 않은 것이라면
			if (!visited[i]) {
				// i번쨰를 고른 것으로 체크
				visited[i] = true;
				// i번째를 현재 순서인 idx에 담고 다음 순서로 이동
				sel[idx] = sy[i];
				perm(idx + 1);
				// 다시 순서로 돌아오면 false로 바꾸고 다음 검사
				visited[i] = false;
			}
		}

	}

	public static long solution(String expression) {
		long answer = 0;

		HashSet<Character> hs = new HashSet<>();
		char[] arr = new char[3];
		int cnt = 0;
		int bb = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-' && !hs.contains('-')) {
				hs.add('-');
				cnt++;
				arr[bb++] = '-';
			} else if (expression.charAt(i) == '+' && !hs.contains('+')) {
				hs.add('+');
				cnt++;
				arr[bb++] = '+';
			} else if (expression.charAt(i) == '*' && !hs.contains('*')) {
				hs.add('*');
				cnt++;
				arr[bb++] = '*';
			}
		}

		sy = new char[cnt];
		sel = new char[cnt];
		visited = new boolean[cnt];

		for (int i = 0; i < cnt; i++) {
			sy[i] = arr[i];
		}

		int f = cnt == 3 ? 6 : cnt;

		s = new char[f][cnt];

		perm(0);
		for (int k = 0; k < f; k++) {

			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder(); // 이어붙이고 수정하고 이어붙이고 수정하고 마지막에 완성된 string을 꺼냄

			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				// 피연산자면 그냥 출력한다.
				if (Character.isDigit(c)) {
					char aa = expression.charAt(i);
					int j;
					for (j = i; Character.isDigit(aa) && j < expression.length(); j++) {
						aa = expression.charAt(j);
						sb.append(aa);// System.out.print(c);
						if (j+1 < expression.length()) {
							aa = expression.charAt(j + 1);
							if (!Character.isDigit(aa)) {
								break;
							}
						}
					}
					i = j;
					sb.append(" ");
				}
				// 연산자면
				else {
					// 스택이 비었으면 그냥 push
					if (stack.isEmpty())
						stack.push(c);
					// 덧셈이면, 스택이 빌 때까지 다 꺼내고 push
					else if (c == s[k][0]) {
						while (!stack.empty())
							sb.append(stack.pop());// System.out.print(stack.pop());
						stack.push(c);
					}

					// 곱셈이면, 스택이 비어있지 않으면서 맨 위에 덧셈이 나올때까지 다 꺼내고 push
					else if (cnt >= 2 && c == s[k][1]) {
						while (!stack.empty() && stack.peek() != s[k][0]) {
							sb.append(stack.pop());// System.out.print(stack.pop());
						}
						stack.push(c);
					}

					else if (cnt == 3 && c == s[k][2]) {
						while (!stack.empty() && stack.peek() != s[k][0] && stack.peek() != s[k][1]) {
							sb.append(stack.pop());// System.out.print(stack.pop());
						}
						stack.push(c);
					}

				}
			}

			while (!stack.empty())
				sb.append(stack.pop());// System.out.println(stack.pop());


			// 식을 순회하면서
			Stack<Long> calStack = new Stack<>();

			for (int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				// 피연산자면 스택에 담는다.
				if (Character.isDigit(c)) {
					StringBuilder sbb = new StringBuilder();
					char aa = sb.charAt(i);
					int j;
					for (j = i; Character.isDigit(aa) && j < sb.length(); j++) {
						aa = sb.charAt(j);
						sbb.append(aa);// System.out.print(c);
						if (j+1 < sb.length()) {
							aa = sb.charAt(j + 1);
							if (!Character.isDigit(aa)) {
								break;
							}
						}
					}
					i = j;
					calStack.add(Long.parseLong(sbb.toString()));
				}
				// 연산자면, 스택에서 두개 꺼내서 해당 연산 후 결과를 스택에 담는다.
				else if(c != ' '){
					long num2 = calStack.pop();
					long num1 = calStack.pop();
					switch (c) {
					case '+':
						calStack.push(num1 + num2);
						break;
					case '-':
						calStack.push(num1 - num2);
						break;
					case '*':
						calStack.push(num1 * num2);
						break;
					}
				}
			}

			// 식이 끝난 후
			// 스택에 들어있는 그 하나의 숫자가 정답!
			long cal = calStack.pop();
			if(cal<0)
				cal = Math.abs(cal);
			if (answer < cal) {
				answer = cal;
			}
		}
		return answer;
	}

}
