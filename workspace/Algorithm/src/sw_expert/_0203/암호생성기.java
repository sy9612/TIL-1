package sw_expert._0203;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int TC = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				int buf = sc.nextInt();
				q.add(buf);
			}
			while (true) {
				int buf = 0;
				for (int i = 1; i <= 5; i++) {
					buf = q.poll();
					buf -= i;
					if (buf <= 0) {
						buf = 0;
						q.add(buf);
						break;
					}
					q.add(buf);
				}
				if(buf == 0)
					break;
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
