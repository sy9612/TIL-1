
import java.util.Scanner;

/**
 * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하여 숫자 사이에 X 혹은 + 연산자를 넣어 가장 큰 수를 구하는 프로그램
 * @author 15com
 *
 */
public class 곱하기혹은더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		int result = S.charAt(0) - '0';
		for (int i = 1; i < S.length(); i++) {
			int buf = S.charAt(i) - '0';
			if(result == 0 || buf == 0 || buf == 1) {
				result += buf;
			}
			else
				result *= buf;
		}
		
		System.out.println(result);
	}
}
