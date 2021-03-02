import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ특정거리의도시찾기_18352 {
	private static int K;
	private static ArrayList<Integer>[] al;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		// 거리 정보
		K = sc.nextInt();
		// 출발
		int X = sc.nextInt();

		al = new ArrayList[N + 1];

		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			al[sc.nextInt()].add(sc.nextInt());
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(X);

		int[] check = new int[N + 1];
		while (!q.isEmpty()) {
			int buf = q.poll();

			for (int i = 0; i < al[buf].size(); i++) {
				if (check[al[buf].get(i)] == 0) {
					check[al[buf].get(i)] = check[buf]+1;
					q.add(al[buf].get(i));
				}
			}
		}

		boolean ok = false;
		for (int i = 1; i < check.length; i++) {
			if (check[i] == K && i != X) {
				ok = true;
				System.out.println(i);
			}
		}
		if (!ok)
			System.out.println(-1);

	}

}
