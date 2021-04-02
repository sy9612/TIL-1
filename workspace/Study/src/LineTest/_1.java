package LineTest;

import java.util.*;

public class _1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		System.out.println(solution(a));
	}

	public static int solution(String inputString) {
		int answer = 0;

		Stack<Character> st = new Stack<>();
		boolean ok = true;
		for (int s = 0; s < inputString.length(); s++) {
			char ch = inputString.charAt(s);

			switch (ch) {
			case '(':
			case '{':
			case '[':
			case '<':
				st.add(ch);
				break;
			case ')':
			case '}':
			case ']':
			case '>':
				if (!st.isEmpty()) {
					char p = st.pop();
					if (p == '(' || p == '{' || p == '[' || p == '<') {
						answer++;
					} else
						ok = false;

				} else
					ok = false;
				break;
			}

			if (!ok) {
				answer = -1;
				break;
			}
		}
		
		if(!st.isEmpty())
			answer = -1;

		return answer;
	}
}
