import java.util.Scanner;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057 ���ڿ����� ��� ����� ���� �����Ͽ�
 * ���� Ž�� ����
 * 
 * @author 15com
 *
 */
public class 문자열압축{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int answer = s.length();
		for (int i = 1; i < s.length(); i++) {
			String sub = s.substring(0, i);
			String compressed = "";
			int cnt = 1;
			for (int j = i; j < s.length(); j += i) {
				if (j + i <= s.length() && sub.equals(s.substring(j, j + i))) {
					cnt++;
				} else {
					if (cnt >= 2)
						compressed += cnt + sub;
					else
						compressed += sub;

					if (j + i >= s.length())
						sub = s.substring(j, s.length());
					else
						sub = s.substring(j, j + i);
					cnt = 1;
				}
			}
			if (cnt >= 2)
				compressed += cnt + sub;
			else
				compressed += sub;
			answer = Math.min(answer, compressed.length());
		}

		System.out.println(answer);

	}
}
