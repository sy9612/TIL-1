package chap01;

import java.util.Random;

public class ifTest {
	public static void main(String[] args) {
		Random ran = new Random();
		ran.nextInt(100);
		int jumsu = ran.nextInt(100)+1;
		System.out.println(jumsu);
		if(jumsu>=90) {
			System.out.println("A");
		}
		else if(jumsu>=80) {
			System.out.println("B");
		}
		else if(jumsu>=70) {
			System.out.println("C");
		}
		else if(jumsu>=60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
		
	}
}
