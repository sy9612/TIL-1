package BAEKJOON;

import java.util.*;

public class 부등호_2529 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ieq = new char[N];

		for (int i = 0; i < N; i++) {
			ieq[i] = sc.next().charAt(0);
		}

		visited = new boolean[10];
		result = new int[N + 1];

		//시작점을 0부터 9까지
		for(int i=0; i<10; i++) {
			perm(0, i);
		}
		
		//최댓값 최솟값
		System.out.println(max);
		System.out.println(min);

	}

	static char ieq[];
	static String min = "9876543210";
	static String max = "0123456789";
	static boolean visited[];
	static int result[];

	private static void perm(int idx, int start) {
		// 결과만큼 채워지면
		if (idx+1== result.length) {
			//마지막 글자 삽입
			result[idx] = start;
			
			//최대, 최소 비교
			String a = "";
			for(int i=0; i<result.length; i++) {
				a += (""+result[i]);
			}
			
			Long num = Long.parseLong(a);
			
			if(Long.parseLong(min)> num)
				min = a;
			else if(Long.parseLong(max) < num)
				max = a;
			
			return;
		}
		//방문하지 않았을 때
		if (!visited[start]) {
			result[idx] = start;
			visited[start] = true;
			
			switch (ieq[idx]) {
			case '<':
				//다음 값이 커야 하면
				for(int i=start+1; i<10; i++)
				{
					//방문하지 않고 현재 자신보다 클 때 재귀
					if(!visited[i]) {
						perm(idx+1,i);
					}
				}
				
				break;
			case '>':
				//다음 값이 작아야 하면
				for(int i= start-1; i>=0; i--) {
					//방문하지 않고 현재 자신보다 작을 때 재귀
					if(!visited[i]) {
						perm(idx+1, i);
					}
				}
				break;
			}
			//방문 해제
			visited[start] = false;
			
		}
	}

}
