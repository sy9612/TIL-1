package sw_expert._0217;
import java.util.*;
public class 단순2진암호코드_1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N][M];
			String input[] = new String[N];
			int st[] = new int[2];
			boolean s = false;
			for(int i=0; i<N; i++) {
				String buf = sc.next();
				input[i] = buf;
				for(int j=0; j<M; j++) {
					arr[i][j] = buf.charAt(j) - '0';
					if(arr[i][j] == 1 && s == false) {
						st[0] = i;
						s = true;
					}
				}
			}
			
			String[] num = {
					"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111","0111011","0110111","0001011"
			};
			
			int x = st[0];
			int y = 0;
			for(int i=M-1; i>=0; i--) {
				if(arr[x][i] == 1) {
					y = i;
					break;
				}
			}
			
			boolean sign = false;
			int result[] = new int[8];
			int rc = 7;
			for(int i=y; i>=7; i--) {
				for(int j=0; j<num.length; j++) {
					if(input[x].substring(i-6, i+1).equals(num[j])) {
						result[rc] = j;
						rc--;
						if(rc == -1) {
							sign = true;
							break;
						}
						i-=6;
						break;
					}
				}
				if(sign == true)
					break;
			}
			int sum =0;
			for(int i=0; i<7; i++) {
				if((i+1)%2 == 0) {
					sum += result[i];
				}
				else {
					sum += (result[i] * 3);
				}
			}
			sum+= result[7];
			
			int r =0;
			if(sum%10 == 0) {
				for(int i=0; i<result.length; i++){
					r += result[i];
				}
				System.out.println(r);
			}
			else {
				System.out.println(0);
			}
			
		}
	}
}
