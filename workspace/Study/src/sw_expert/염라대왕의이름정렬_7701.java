package sw_expert;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 정렬 - 우선순위
 * 중복을 제거 (tree set)
 * 시간 over
 * 선택정렬 O[N^2]
 * 
 * 
 */
public class 염라대왕의이름정렬_7701 {
	static int N;
	static String[] name;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			name = new String[N];
			
			for(int i=0; i<N; i++) {
				name[i] = sc.next();
			}
			
			// 선택정렬 - 우선순위
			for (int i = 0; i < name.length; i++) { //범위의 시작값
				int minIndex = i; // 최소값의 방번호
				for(int j=i; j<name.length; j++) {
					if(compare(name[minIndex], name[j]) > 0) { // 최소값이라면, 앞쪽에 배치해야 된다면
						//swap
						minIndex = j; // 최소값 인덱스 기억
					}
				}
				// swap name[i] <-> name[minIndex]
				String temp = name[i];
				name[i] = name[minIndex];
				name[minIndex] = name[i];
			}
			// 중복 제거
			System.out.println(Arrays.toString(name));
			
			String temp = null;
			for(int i=0; i<name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		}
	}
	/** 바꿔야 하면, (next가 앞으로 이동) 양수를 리턴 */
	private static int compare(String pre, String next) {
		// TODO Auto-generated method stub
		if(pre.length() != next.length()) { //글자의 길이 짧은 순서
			return pre.length() - next.length();
		}else { // 길이가 같을 때
			return pre.compareTo(next); //오름차순
		}
	}
}
