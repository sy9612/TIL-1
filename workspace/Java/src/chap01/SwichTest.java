package chap01;

import java.util.Random;

public class SwichTest {
	public static void main(String[] args) {
		
		//랜덤 출력
		Random ran = new Random();
		int jumsu = ran.nextInt(100) + 1;
		System.out.println(jumsu);
		
		Math.random(); // 0부터 1사이의 실수값
		
		//switch문이 같은 것만 판단하기 때문
		switch (jumsu/10) {
		case 10:		
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
	}
}
