package 연습장;
import java.util.Scanner;

public class 단어의개수_지혜 {
	public static void main(String[] args) {
		int start = 0;
		int end = 0;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for (int i = 0; i < input.length(); i++) { // 시작점 구하기
			if (input.charAt(i) != ' ') {
				start = i;
				break;
			}
		}
	
		for (int i = input.length() - 1; i >= 0; i--) { // 끝점 구하기
			if (input.charAt(i) != ' ') {
				end = i;
				break;
			}
		}
		int cnt = 0;
		
		if(start == 0 && end ==0) { //공백만 있으면 
			cnt = 0;
		}
		else {
			for (int i = start; i <= end; i++) { // 단어 사이 공백구하기 
				if (input.charAt(i) == ' ')
					cnt++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}