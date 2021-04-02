package 이것이코딩테스트다;

import java.util.Scanner;

/**
 * �ϳ��� ���ڿ� S�� �ִ� ��� ���ڸ� ����
 * @author 15com
 *
 */
public class 문자열뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		int cnt1 = 0;
		int cnt0 = 0;
		
		if(S.charAt(0) == '1') {
			cnt0 ++;
		}
		else
			cnt1 ++;
		
		for (int i = 0; i < S.length()-1; i++) {
			if(S.charAt(i) != S.charAt(i+1)) {
				if(S.charAt(i+1) == '1')
					cnt0++;
				else
					cnt1++;
					
			}
		}
		
		System.out.println(Math.min(cnt0, cnt1));
	}
}
