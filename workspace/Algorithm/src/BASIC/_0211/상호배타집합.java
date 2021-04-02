package BASIC._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 상호배타집합 {
	static int[] parents;
	public static void main(String[] args) {
		//첫번째 줄에는 원소의 개수와 유니온 연산의 개수가 들어온다.
		//두번째 줄부터 유니온 연산의 개수만큼, 각 줄에 합칠 원소 두 개를 주어준다.
		Scanner sc = new Scanner("10 9\n" +
				"1 2\n" +
				"1 3\n" +
				"1 4\n" +
				"1 5\n" +
				"1 6\n" +
				"1 7\n" +
				"1 8\n" +
				"1 9\n" +
				"1 10\n"
				);
		int N = sc.nextInt();
		int M = sc.nextInt();
		//원소의 개수만큼 parents배열 준비
		//각 원소 makeset
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		rank = new int[N+1];
		//유니온 연산 후 집합의 개수를 출력
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionSet(a,b);
		}
		System.out.println(Arrays.toString(parents));
	}
	static int findSet(int x) {
		// 내 부모가 나라면 내가 대표자
		if(x == parents[x])
			return x;
		else {
			//아니라면 부모에 대해 대표자 찾기 재귀호출
			parents[x] =  findSet(parents[x]);
			return parents[x];
		}
	}
	static int[] rank;
	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		//px와 py의 랭크를 비교해서 더 낮은 것을 높은 것에 붙임
		//랭크가 같은 경우 아무나 붙이되 부모가 되는 쪽의 랭크를 하나 증가
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else if(rank[px] < rank[py]) {
			parents[px] = py;
		}
		else {
			parents[px] = py;
			rank[py]++;
		}
		//parents[px] = py;
	}

}
