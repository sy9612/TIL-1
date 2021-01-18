import java.util.Scanner;

//분할정복
public class 곱셈_1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
//		A^B % C
		System.out.println(cal(A, B, C) % C); 
	}

	private static long cal(long a, long b, long c) {
		// TODO Auto-generated method stub
		if(b == 0) {
			return 1;
		}
		else if( b== 1) {
			return a;
		}
		else if(b%2 == 0) {
			long n = cal(a,b/2, c) % c;
			return (n*n)%c;
		}else {
			long n = cal(a,b/2, c) % c;
			return (((n*n) % c) * a) % c;
		}
	}
}
