
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> al = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			al.add(sc.nextInt());
		}

		int result = 0;

		while (al.size() > 1) {
			
			int a = al.poll();
			int b = al.poll();

			result += a+b;
			al.add(a+b);
		}
		
		
		System.out.println(result);

	}

}
