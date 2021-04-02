package chap01._0122;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result = b + 100 - a;
		
		if(result>0) {
			System.out.println("비만수치는 "+ result + "입니다.\n 당신은 비만이군요");
		}	
		
	}
}
