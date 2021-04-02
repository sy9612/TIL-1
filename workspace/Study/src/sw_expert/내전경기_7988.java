package sw_expert;

import java.util.*;

public class 내전경기_7988 {
	static HashMap<String, Integer> person;
	static int K;
	static int[][] rl;
	static int p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			K = sc.nextInt();
			person = new HashMap<>();
			rl = new int[K * 2][K * 2];
			p = 0;

			for (int i = 0; i < K; i++) {
				String a = sc.next();
				String b = sc.next();

				if (!person.containsKey(a))
					person.put(a, p++);
				if (!person.containsKey(b))
					person.put(b, p++);

				rl[person.get(a)][person.get(b)] = 1;
				rl[person.get(b)][person.get(a)] = 1;
			}
			boolean result = false;
			LinkedList<Integer> q = new LinkedList<>();

			for (int i = 0; i < p; i++) {
				q.add(i);
				int cnt = 0;
				int cnt2 =0;
				boolean visited[] = new boolean[p];
				int[] t1 = new int[p];
				int[] t2 = new int[p];
				while (!q.isEmpty()) {
					int v = q.poll();
					for (int j = 0; j < p; j++) {
						if (visited[v] == false && rl[v][j] == 0) {
							visited[j] = true;
							t1[cnt++] = j;
							q.add(j);
						}
						else if(visited[v] == false && rl[v][j] == 1) {
							visited[j] = true;
							t2[cnt2++] = j;
						}
					}
				}
			}

			if (result)
				System.out.println("Yes");
			else
				System.out.println("No");

		}
	}

	static int[] team;

}
