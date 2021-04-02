package LineTest;

import java.util.*;

public class _2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b[] = new String[4];
		for (int i = 0; i < 4; i++) {
			b[i] = sc.next();
		}
		System.out.println(solution(a, b));
	}

	public static int solution(String answer_sheet, String[] sheets) {
		int answer = 0;
		int cnt = 0;
		int line = 0;
		int max = 0;

		for (int i = 0; i < sheets.length; i++) {
			for (int j = i + 1; j < sheets.length; j++) {
				int cnt1 =0;
				int line1 =0;
				int max1 =0;
				for (int k = 0; k < answer_sheet.length(); k++) {
					boolean ok = false;
					if (sheets[i].charAt(k) == sheets[j].charAt(k) && answer_sheet.charAt(k) != sheets[i].charAt(k)) {
						ok = true;
					}
					if (max1 < line1)
						max1 = line1;
					if (ok) {
						cnt1++;
						line1++;
					} else {
						
						line1 = 0;
					}
				}
				if (max1 < line1)
					max1 = line1;
				if(max < max1)
					max = max1;
				if(cnt < cnt1)
					cnt = cnt1;
			}
			
		}

		answer = (int) (cnt + Math.pow(max, 2));

		return answer;
	}
}
