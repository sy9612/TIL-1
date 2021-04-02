package sw_expert.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * 정렬 - 우선순위
 * 중복을 제거 (tree set)
 * 선택정렬 O[N^2] -> 시간 오버
 * API 정렬 O[NlogN] : 3100ms, 중복을 직접 제거
 * 중복제거를 TreeSet O[NlogN] : 2900ms
 * API 정렬 + 중복제거 TreeSet + 입출력 최적화
 */
public class 염라대왕의이름정렬_7701_Solution {
	static int N;
	//static String[] name;
	static TreeSet<String> name;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			//name = new String[N];
			name = new TreeSet<String>(new Comparator <String>() {
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) { //글자의 길이 짧은 순서
						return pre.length() - next.length();
					}else { // 길이가 같을 때
						return pre.compareTo(next); //오름차순
					}
				}
			}); 
			for(int i=0; i<N; i++) {
				name.add(sc.next()); // 중복이 자동으로 제거됨
			}
			
			/** API 이용
			Arrays.sort(name, new Comparator<String>() {

				@Override
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) { //글자의 길이 짧은 순서
						return pre.length() - next.length();
					}else { // 길이가 같을 때
						return pre.compareTo(next); //오름차순
					}
				}
				
			});
			
			// 중복 제거
			System.out.println(Arrays.toString(name));
			
			String temp = null;
			for(int i=0; i<name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}*/
		}
	}

}
