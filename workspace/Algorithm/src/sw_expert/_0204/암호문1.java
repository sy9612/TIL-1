package sw_expert._0204;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			LinkedList<Integer> secret = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int buf = sc.nextInt();
				secret.add(buf);
			}
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				String I = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();

				for (int j = x; j < x + y; j++) {
					int buf = sc.nextInt();
					secret.add(j, buf);
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(secret.poll() + " ");
			}
		}
	}
}
