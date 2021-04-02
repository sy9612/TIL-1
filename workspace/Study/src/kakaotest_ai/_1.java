package kakaotest_ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		//0 = 소, 1= 대, 3=숫자, 4=특수
		boolean check[] = new boolean[4];
		int level = 0;
		if(input.length() >= 10) {
			level ++;
		}
		for (int i = 0; i < input.length(); i++) {
			char s = input.charAt(i);
			String st = s + "";
			if(Character.isUpperCase(s) && !check[1]) {
				level++;
				check[1] = true;
			}
			else if(Character.isLowerCase(s) && !check[0]) {
				level++;
				check[0] = true;
			}
			else if(isNumber(st) && !check[2]) {
				level++;
				check[2] = true;
			}
			else if(!Character.isUpperCase(s)&&!Character.isLowerCase(s) && !isNumber(st) && !check[3]) {
				level++;
				check[3] = true;
			}
		}
		
		System.out.println("LEVEL" + level);
		
	}
	public static boolean isNumber(String s) {
		  try {
			  Integer.parseInt(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
		}
}
