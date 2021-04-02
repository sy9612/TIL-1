package 이것이코딩테스트다;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();

		ArrayList<Character> al = new ArrayList<>();
		int number = 0;
		for (int i = 0; i < N.length(); i++) {
			if (0 <= N.charAt(i)-'0' && N.charAt(i)-'0' <= 9) {
				number += N.charAt(i) - '0';
			} else
				al.add(N.charAt(i));
		}
	
		Collections.sort(al);
		
		
		for (int i = 0; i < al.size(); i++) 
			System.out.print(al.get(i));
		if(number != 0)
			System.out.println(number);
	}
}
