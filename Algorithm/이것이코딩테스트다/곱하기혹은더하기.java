
import java.util.Scanner;

/**
 * ���ʺ��� ���������� �ϳ��� ��� ���ڸ� Ȯ���Ͽ� ���� ���̿� X Ȥ�� + �����ڸ� �־� ���� ū ���� ���ϴ� ���α׷�
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
