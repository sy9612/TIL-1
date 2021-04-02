package BAEKJOON;

import java.util.*;

public class 단어수학_1339 {
	static boolean visited[] = new boolean[123];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] s = new String[N];

		for (int i = 0; i < N; i++) {
			s[i] = sc.next();
		}
		Integer result[] = new Integer[123];
		Arrays.fill(result,0);
		
		for(int i=0; i<N; i++) {
			for(int j=s[i].length()-1; j>=0; j--) {
				int a = (int)Math.pow(10, j);
				result[s[i].charAt(s[i].length()-1-j)-'0'] += a;
			}
		}
		
		Arrays.sort(result);
		int cnt = 9;
		int sum = 0;
		for(int i=122; i>=97; i--) {
			if(result[i] != 0) {
				sum += result[i]*cnt;
				cnt--;
			}
			else {
				break;
			}
		}
		
		System.out.println(sum);
	}
}

/*
 * HashMap<Character, Integer> m = new HashMap<>();
 * 
 * Arrays.sort(s, new Comparator<String>() {
 * 
 * @Override public int compare(String o1, String o2) { // TODO Auto-generated
 * method stub if (o1.length() > o2.length()) return -1; return 0; }
 * 
 * });
 * 
 * int mm[] = new int[10]; int mmcnt = 0; for (int i = 0; i < s.length; i++) {
 * int k = s[i].length(); for (int j = 0; j < s[i].length(); j++) { if
 * (!m.containsKey(s[i].charAt(j))) { m.put(s[i].charAt(j), k); mm[mmcnt++] = k;
 * } else if(m.get(s[i].charAt(j))< k) { for(int z = 0; z < mmcnt; z++) {
 * if(mm[z] == m.get(s[i].charAt(j))) { mm[z] = k; break; } }
 * m.replace(s[i].charAt(j), k); } k--; }
 * 
 * }
 * 
 * Arrays.sort(mm);
 * 
 * int count = m.size(); int cnt = 9; mmcnt = 9; while (count > 0) { for
 * (Character key : m.keySet()) { if(mmcnt <0) break; if (m.get(key) ==
 * mm[mmcnt] && visited[key] == false) { visited[key] = true; m.replace(key,
 * cnt); cnt--; count++; mmcnt--; } } count--; }
 * 
 * long sum = 0l; for (int i = 0; i < s.length; i++) { String before = ""; for
 * (int j = 0; j < s[i].length(); j++) { int b = m.get(s[i].charAt(j)); before
 * += "" + b; } sum += Long.parseLong(before); }
 * 
 * System.out.println(sum);
 * 
 * }
 */

/*
 * static boolean visited[] = new boolean[10]; static char alpha[] = new
 * char[36]; static HashMap<Character, Integer> m; static int arr[]; static
 * String[] s;
 * 
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * int N = sc.nextInt(); s = new String[N];
 * 
 * m = new HashMap<>(); arr = new int[N]; for (int i = 0; i < N; i++) { s[i] =
 * sc.next(); for (int j = 0; j < s[i].length(); j++) { m.put(s[i].charAt(j),
 * -1); } } Set set = m.keySet(); Iterator<Character> it = set.iterator();
 * 
 * perm(0,it);
 * 
 * System.out.println(max); }
 * 
 * static long max = 0l;
 * 
 * private static void perm(int idx, Iterator<Character> it) { if (idx ==
 * m.size()) { long sum = 0l; for (int i = 0; i < s.length; i++) { String before
 * = ""; for(int j=0; j<s[i].length(); j++) { int b = m.get(s[i].charAt(j));
 * before += "" + b; } sum += Long.parseLong(before); }
 * 
 * if(max < sum) max = sum; return; }
 * 
 * 
 * 
 * for (int i = 9; i >= 0; i--) { if (!visited[i]) { if(!it.hasNext()) return;
 * char key = it.next(); m.replace(key, i); visited[i] = true; perm(idx + 1,it);
 * visited[i] = false;
 * 
 * } }
 * 
 * }
 */