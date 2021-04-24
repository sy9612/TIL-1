package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 영단어암기는괴로워_20920 {
//	static class Word implements Comparable<Word>{
//		String st;
//		int cnt;
//		
//		Word(String st, int cnt){
//			this.st = st;
//			this.cnt = cnt;
//		}
//
//		@Override
//		public int compareTo(Word o) {
//			if(this.cnt == o.cnt) {
//				if(this.st.length() == this.st.length()) {
//					return this.st.compareTo(o.st);
//				}
//				return o.st.length() - this.st.length();
//			}
//			return o.cnt - this.cnt;
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String b = br.readLine();
		int N = Integer.parseInt(b.split(" ")[0]);
		int M = Integer.parseInt(b.split(" ")[1]);
		
		Map<String, Integer> exist = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String buf = br.readLine();
			if(buf.length() < M) {
				continue;
			}
			
			if(exist.containsKey(buf)) {
				exist.replace(buf, exist.get(buf)+1);
			}else {
				exist.put(buf, 0);
			}
		}
		
		List<String> keySet = new ArrayList<>(exist.keySet());
		
		keySet.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				if(exist.get(o1) == exist.get(o2)) {
					return o1.compareTo(o2);
				}
				return exist.get(o2) - exist.get(o1);
			}
			
		});
				
		for(String key: keySet) {
			System.out.println(key);
		}
	}
}
