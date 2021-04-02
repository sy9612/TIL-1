package sw_expert;

import java.util.Scanner;

public class 날짜계산기_1948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int tc = 1; tc <= T; tc++) {
			int mon[] = new int[2];
			int day[] = new int[2];
			int result = 0;
			for(int i=0; i<2; i++) {
				mon[i] = sc.nextInt();
				day[i] = sc.nextInt();
			}
			
			if(mon[0] == mon[1]) {
				result = day[1] - day[0] + 1;
			}
			else {
				for(int i=mon[0]; i <mon[1]; i++) {
					if(i==2) {
						if(i == mon[0]) {
							result += (28 - day[0]);
						}
						else
							result += 28;
						
					}
					else if(i==1 || i ==3 || i ==5 || i==7 || i==8 || i==10 || i == 12) {
						if(i==mon[0])
							result += (31 - day[0]);
						else
							result += 31;
						
					}
					else
					{
						if(i == mon[0])
							result += (30 - day[0]);
						else
							result += 30;
					}
				}
				result += day[1];
				result++;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	
	}


}
