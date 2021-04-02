package kakao_2020;

public class _1 {
	public static void main(String[] args) {

		String new_id ="abcdefghijklmn.p";
		String answer = solution(new_id);
		System.out.println(answer);
	}

	public static String solution(String new_id) {
		String answer = "";
		
		new_id = new_id.toLowerCase();
		
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			
			boolean ok = false;
			
			if(new_id.charAt(i) >= 97 && new_id.charAt(i)<=122) {
				ok = true;
			}
			if(new_id.charAt(i) >= 48 && new_id.charAt(i) <= 57) {
				ok = true;
			}
			if(new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.')
				ok = true;
			
			if(ok) {
				st.append(new_id.charAt(i));
			}
		}
		
		new_id = st.toString();
		
		st = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			
			if(new_id.charAt(i) == '.') {
				int j;
				for ( j = i+1; j < new_id.length(); j++) {
					if(new_id.charAt(j) != '.') {
						break;
					}
				}
				st.append(new_id.charAt(i));
				i = j-1;
			}
			
			else {
				st.append(new_id.charAt(i));
			}
			
		}
		
		
		if(st.charAt(0) == '.') {
			st.delete(0, 1);
		}
		if(st.length() != 0 && st.charAt(st.length()-1) == '.') {
			st.delete(st.length()-1, st.length());
		}
		
		new_id = st.toString();
		
		st = new StringBuilder(new_id);
		
		if(st.length() == 0) {
			st.append("a");
		}
		
		if(st.length() >= 16) {
			st.delete(15, st.length());
		}
		
		if(st.charAt(st.length()-1) == '.') {
			st.delete(st.length()-1, st.length());
		}
		
		
		
		if(st.length() <= 2) {
			while(st.length() < 3) {
				st.append(st.charAt(st.length()-1));
			}
		}
		
		answer = st.toString();
		
		return answer;
	}
}
