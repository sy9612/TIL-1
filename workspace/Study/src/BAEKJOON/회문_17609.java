package BAEKJOON;

import java.util.Scanner;

public class 회문_17609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String st = sc.next();
			
			int len = st.length();
			
			int result = 0;
			int left = 0;
			int right = 0;
			for (int j = 0; j <= len/2; j++) {
				if(result == 2) break;
				if(result == 1) {
					boolean ok = false;
					if(left != 0 && st.charAt(j+left) == st.charAt(len-j-1)){
						ok = true;
					}
					if(right != 0 && st.charAt(j) == st.charAt(len-j-1-right)){
						ok = true;
					}

					if(ok) continue;
					else {
						result++;
						break;
					}
				}
				else if(st.charAt(j+left) != st.charAt(len-j-1-right)){
					result++;
					if(st.charAt(j+1) == st.charAt(len-j-1-right)) left++;
					if(st.charAt(j) == st.charAt(len-j-2)) right++;
					j--;
				}
			}
			System.out.println(result);
		}
	}
}
