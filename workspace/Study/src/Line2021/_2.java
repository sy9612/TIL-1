package Line2021;

import java.util.ArrayList;
import java.util.Arrays;

public class _2 {
	public static void main(String[] args) {
		String inp_str = "ZzZz9Z824";

		solution(inp_str);
	}

	public static int[] solution(String inp_str) {
		
		ArrayList<Integer> rs = new ArrayList<>();
		
		// 1번 길이
		
		if(inp_str.length() <8 || inp_str.length() >15)
			rs.add(1);
		
		// 2번 다른 문자
		
		String c = "~!@#$%^&*";
		boolean[] check = new boolean[4];
		for (int i = 0; i < inp_str.length(); i++) {
			char buf = inp_str.charAt(i);
			if(buf >= 'A' && buf <= 'Z' ) {
				check[0] = true;
				continue;
			}
			if(buf>='a' && buf<= 'z') {
				check[1] = true;
				continue;
			}
			if(buf >= '0' && buf <= '9') {
				check[2] = true;
				continue;
			}
			if(c.contains(String.valueOf(buf))) {
				check[3] = true;
				continue;
			}
			if(!rs.contains(2))
				rs.add(2);
		}
		
		int cnt3= 0;
		for (int i = 0; i < check.length; i++) {
			if(check[i])
				cnt3++;
		}
		if(cnt3 <3) {
			if(!rs.contains(3))
			rs.add(3);
		}
		
		
		// 4번
		for (int i = 0; i < inp_str.length(); i++) {
			
			char num = inp_str.charAt(i);
			int cnt = 1;
			boolean ok = false;
			
			for (int j = i+1; j < inp_str.length(); j++) {
				if(inp_str.charAt(j) == num) {
					cnt++;
				}
				if(cnt == 4)
				{
					ok = true;
					if(!rs.contains(4))
						rs.add(4);
					break;
				}
				i = j;
			}
			if(ok)
				break;
		}
		
		
		for (int i = 0; i < inp_str.length(); i++) {
			
			char buf = inp_str.charAt(i);
			int cnt = 1;
			for (int j = 0; j < inp_str.length(); j++) {
				if(i != j && buf == inp_str.charAt(j)) {
					cnt++;
				}
			}
			if(cnt >= 5) {
				if(!rs.contains(5))
					rs.add(5);
				break;
			}
		}
		
		if(rs.size() == 0)
		{
			int[] answer = new int[1];
			answer[0] = 0;

//			System.out.println(Arrays.toString(answer));
			return answer;
		}
		int[] answer = new int[rs.size()];
		
		for (int i = 0; i < rs.size(); i++) {
			answer[i] = rs.get(i);
		}
		
//		System.out.println(Arrays.toString(answer));
		
		
		
		return answer;
	}
}
