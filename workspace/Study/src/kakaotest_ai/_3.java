package kakaotest_ai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class _3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		double N = Double.parseDouble(st[0]);
		double K = Double.parseDouble(st[1]);
		
		double stick[] = new double[(int)N];
		
		double total = 0;
		double max = 0;
		double min = Double.MAX_VALUE;
		for (int i = 0; i < (int)N; i++) {
			double buf = Double.parseDouble(br.readLine());
			max = Math.max(buf, max);
			min = Math.min(buf, min);
			total += buf;
			stick[i] = buf;
		}
		
		Arrays.sort(stick);
		
		double na = Double.parseDouble(String.format("%.2f", K/N));
		
		 double rmax = Double.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			double a = stick[i]/K * na;
	         if(a<min) {
	            if(a*K <= total) {
	               rmax = Math.max(rmax, a);
	            }
	         }
	      }
		
		System.out.println(Double.parseDouble(String.format("%.2f", rmax)));
	}
}
