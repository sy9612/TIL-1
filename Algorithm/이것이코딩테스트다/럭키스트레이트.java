
import java.util.Scanner;

public class 럭키스트레이트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		int a1 = 0;
		int a2 = 0;
		for (int i = 0; i < N.length()/2; i++) {
			a1 += N.charAt(i) - '0';
			a2 += N.charAt(N.length()-i-1) - '0';
		}
		
		System.out.println(a1 == a2 ? "LUCKY" : "READY");
	}
}
