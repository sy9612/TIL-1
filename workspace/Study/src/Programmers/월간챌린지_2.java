package Programmers;

import java.util.Stack;

public class 월간챌린지_2 {
	public static void main(String[] args) {
		solution("{()}{");
	}

	public static int solution(String s) {
		int answer = 0;

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			String buf = s.substring(i, s.length());
			buf += s.substring(0, i);

			System.out.println(buf);
			boolean ok = true;
			for (int j = 0; j < buf.length(); j++) {
				if(!ok) break;
				if (buf.charAt(j) == '{' || buf.charAt(j) == '(' || buf.charAt(j) == '[') {
					st.add(buf.charAt(j));
					continue;
				}

				switch (buf.charAt(j)) {
				case ')':
				case ']':
				case '}':
					if (st.isEmpty()) {
						ok = false;
						break;
					} else {
						char openPair = st.pop();
						if ( (openPair == '(' && buf.charAt(j) != ')' ) || (openPair == '[' && buf.charAt(j) != ']')|| (openPair == '{' && buf.charAt(j) != '}')) {
							ok = false;
							break;

						} else {
							break;
						}

					}
				}
			}

			if (ok && st.isEmpty())
				answer++;

		}
		System.out.println(answer);
		return answer;
	}
}
