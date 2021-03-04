import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 회장뽑기_2660 {
	private static int N;
	private static int[][] board;
	private static boolean[] check;
	private static int[][] d;

	public static void main(String[] args) {

		// 입력 Scanner
		Scanner sc = new Scanner(System.in);

		// N 입력
		N = sc.nextInt();

		// 배열 입력
		board = new int[N + 1][N + 1];

		// 결과 입력 d[start][i]
		d = new int[N + 1][N + 1];

		// -1이 들어오면 반복문 종료
		// board[a][b] = 1로 인해 서로 관계 정의
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 || b == -1)
				break;

			board[a][b] = 1;
			board[b][a] = 1;
		}

		// 최종 결과
		int[] result = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			check = new boolean[N + 1]; // 매번 check 초기화
			dfs(i, i, 0); // dfs 함수 접근

			//첫번째 인자 i = index: dfs에서 현재 접근하는 위치
			//두번째 인자 i = st: start지점으로 d[start][index]로 최소 값을 담음
			//세번째 인자 0 = dfs 접근 횟수 = start로 부터 얼마나 떨어져 있는 지 count

			Arrays.sort(d[i]);	//최대값을 찾기 위해 정렬
			result[i] =	d[i][d[i].length-1];	//i번째(start) 최대값 저장
		}
		
		// Arrays.sort(result)로 가장 작은 거 찾을 수 있음
		// 0 제외 필수
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < result.length; i++) {
			if(min > result[i])
				min = result[i];
		}

		// min과 동일하면 최소 -> 개수와 배열 추가
		int cnt = 0;
		ArrayList<Integer> rs = new ArrayList<>();
		for (int i = 1; i < result.length; i++) {
			if(min == result[i]) {
				cnt++;
				rs.add(i);
			}
		}
		System.out.println(min + " " + cnt);
		for (int i = 0; i < rs.size(); i++) {
			System.out.print(rs.get(i) +" ");
		}
		

	}

	//dfs 함수
	private static void dfs(int idx, int st, int cnt) {

		//st -> idx 까지 얼마나 멀리 떨어져 있는지
		d[st][idx] = cnt;
		check[idx] = true; //이미 한 번 들렸으면 check

		//1부터 N까지 모두 탐색
		for (int i = 1; i < N + 1; i++) {
			if (board[idx][i] == 1) {	//서로 연결되어 있으면
				//들리지 않았으면 다음 깊이 탐색
				//들렸지만 이전에 가지고 있던 값보다 최소라면 깊이 탐색
				if (!check[i] || cnt + 1 < d[st][i]) {
					dfs(i, st, cnt + 1);	//재귀 -> 함수를 한 번 더 들어가므로 cnt+1, st는 유지, idx는 현재 위치이므로 계속 변경됨
				}
			}
		}
	}

}
