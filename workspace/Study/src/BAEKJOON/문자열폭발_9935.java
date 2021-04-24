package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder sub_st = new StringBuilder(br.readLine());

		Stack<Character> stack = new Stack<>();

		char[] arr = new char[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			arr[i] = sb.charAt(i);
			stack.add(sb.charAt(i));

			if (stack.peek() == sub_st.charAt(sub_st.length() - 1)) {
				if(stack.size() < sub_st.length()) {
					continue;
				}
				boolean ok = true;
				for (int j = 0; j < sub_st.length(); j++) {
					if (stack.get(stack.size() - j -1) != sub_st.charAt(sub_st.length() - j - 1)) {
						ok = false;
						break;
					}
				}
				
				if(ok) {
					for (int j = 0; j < sub_st.length(); j++) {
						stack.pop();
					}
				}

				

			}
		}

		
		if (stack.size() == 0)
			System.out.println("FRULA");
		else {
			StringBuilder s = new StringBuilder();
			for (Character ch : stack) {
				s.append(ch);
			}
			System.out.println(s.toString());
		}

	}
}
