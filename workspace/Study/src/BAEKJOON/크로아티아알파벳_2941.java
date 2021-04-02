package BAEKJOON;

import java.util.Scanner;

public class 크로아티아알파벳_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alpha = sc.next();
		int result = 0;
		
		
		char[][] arr = new char[8][2];
		
		arr[0][0] = 'c'; arr[0][1] = '=';
		arr[1][0] = 'c'; arr[1][1] = '-';
		//arr[2][0] = 'd'; arr[2][1] = 'z'; arr[0][2] = '=';
		arr[3][0] = 'd'; arr[3][1] = '1';
		arr[4][0] = 'l'; arr[4][1] = 'j';
		arr[5][0] = 'n'; arr[5][1] = 'j';
		arr[6][0] = 's'; arr[6][1] = '=';
		arr[2][0] = 'z'; arr[2][1] = '=';

		for (int i = 0; i < alpha.length(); i++) {

			char a = alpha.charAt(i);
			if (a < 97 || a > 122)
				continue;
			result++;
			if (i + 1 < alpha.length()) {
				char b = alpha.charAt(i + 1);
				if (a == 'd') {
					if (i + 2 < alpha.length()) {
						char c = alpha.charAt(i + 2);
						if (b == 'z' && c == '=') {
							i += 2;
						}
					}
				}
				for(int j=0; j<7; j++) {
					if(arr[j][0] == a && arr[j][1] == b) {
						i++;
						break;
					}
				}
			}
		}

		System.out.println(result);

	}

}
