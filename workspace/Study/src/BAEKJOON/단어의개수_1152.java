package BAEKJOON;

import java.util.Scanner;

public class 단어의개수_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		int result=0;
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) == ' ') {
				if(i!=0 && i != word.length()-1)
					result++;
			}
		}
		
		if(result == 0)
		{
			if(word.length() == 1 && word.charAt(0) == ' ')
				System.out.println(result);
			else if(word.charAt(0) == ' ')
				System.out.println(1);
			else
				System.out.println(1);
		}
		else
			System.out.println(result+1);
	}
}
