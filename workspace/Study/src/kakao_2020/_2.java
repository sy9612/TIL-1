package kakao_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _2 {
	public static void main(String[] args) {

		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };
		String[] answer = solution(orders, course);
		System.out.println(answer);
	}

	public static void makeCombination(int n, int start, char[] sel, String arr, HashMap<String, Integer> hs) {
		if (n == 0) {
			Arrays.sort(sel);
			StringBuilder st = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				st.append(sel[i]);
			}
			System.out.println(st.toString());
			if (hs.containsKey(st.toString())) {
				hs.replace(st.toString(), hs.get(st.toString()) + 1);
			} else {
				hs.put(st.toString(), 1);
			}
			return;
		}

		for (int i = start; i < arr.length(); i++) {
			sel[n - 1] = arr.charAt(i);
			makeCombination(n - 1, i + 1, sel, arr, hs);
		}

	}

	public static String[] solution(String[] orders, int[] course) {
		List<String> ans = new ArrayList<>();

		for (int cs = 0; cs < course.length; cs++) {
			HashMap<String, Integer> hs = new HashMap<>();
			for (int i = 0; i < orders.length; i++) {
				combination(0, 0, new char[course[cs]], orders[i], hs);
				System.out.println("-----");
			}

			List<String> keySetList = new ArrayList<>(hs.keySet());
			// 오름차순 //
			Collections.sort(keySetList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return hs.get(o2).compareTo(hs.get(o1));
				}
			});

			if (hs.size() > 0) {
				int max = hs.get(keySetList.get(0));
				if (max >= 2) {
					for (String key : keySetList) {
						if (hs.get(key) == max) {
							ans.add(key);
						} else
							break;
					}
				}
			}
		}

		String[] answer = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}

		Arrays.sort(answer);
		return answer;
	}

	static void combination(int idx, int s_idx, char[] sel, String arr, HashMap<String, Integer> hs) {
		// 원하는 만큼 골랐으므로, 결과 뽑고 리턴
		if (s_idx == sel.length) {
			char[] ss = new char[sel.length];
			for (int i = 0; i < ss.length; i++) {
				ss[i] = sel[i];
			}
			Arrays.sort(ss);
			StringBuilder st = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				st.append(ss[i]);
			}
			System.out.println(st.toString());
			if (hs.containsKey(st.toString())) {
				hs.replace(st.toString(), hs.get(st.toString()) + 1);
			} else {
				hs.put(st.toString(), 1);
			}
			return;
		}
		// 원하는 만큼 뽑지 못했지만, 더 이상 뽑을게 없으므로 리턴
		if (idx == arr.length())
			return;
		sel[s_idx] = arr.charAt(idx);
		// 다음 것을 고르기 위해 s_idx 증가
		combination(idx + 1, s_idx + 1, sel, arr, hs);
		// 이번 고른 걸 무효시키기 위해 s_idx를 그대로
		combination(idx + 1, s_idx, sel, arr, hs);
	}
}
