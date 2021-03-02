import java.util.Scanner;

public class K진트리_11812 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int Q = sc.nextInt();
		
		for (int tc = 0; tc < Q; tc++) {
			long st = sc.nextInt();
			long ed = sc.nextInt();
			
			if( K == 1) {
				System.out.println(Math.abs(st-ed));
				continue;
			}
			
			int cnt = 0;
			while(st != ed) {
				while(st > ed) {
					cnt++;
					st = parent(st,K);
				}
				while(ed > st) {
					cnt++;
					ed = parent(ed, K);
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
		
	}

	private static long parent(long ed, int k) {
		// TODO Auto-generated method stub
		return (ed + k -2) / k;
	}
}
