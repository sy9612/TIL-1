package sw_expert.Solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 정렬 - 우선순위
 * 중복을 제거 (tree set)
 * 선택정렬 O[N^2] -> 시간 오버
 * API 정렬 O[NlogN] : 3100ms, 중복을 직접 제거
 * 중복제거를 TreeSet O[NlogN] : 2900ms
 * API 정렬 + 중복제거 TreeSet + 입출력 최적화: 500 ~ 600ms
 * 
 * 아이디어: 글자 개수에 해당하는 배열에 글자 길이가 동일한 이름들을 TreeSet으로 사전순 정렬
 * 글자 개수가 작은 TreeSet부터 출력
 */
public class 염라대왕의이름정렬_최적화2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // �̸��� ���� 1~20,000
			
			TreeSet<String>[] tsrr = new TreeSet[51]; 
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i] = new TreeSet<String>(); // �迭 �� ĭ�� �����ؼ� �ֱ�
			}
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}
			
			// 중복제거
			sb.append('#').append(testCase).append('\n');
			for (int i = 1; i < tsrr.length; i++) {
				for (String string : tsrr[i]) {
					sb.append(string).append('\n');
				}
			}
		} // end of testCase
		System.out.print(sb);
	} // end of main
} // end of class










