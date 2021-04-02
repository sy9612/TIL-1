package BASIC._0203;

public class 원형큐_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue = new int[10];
		int front = 0;
		int rear = 0;
		
		//삽입
		queue[ ++rear % 10] = 10;
		
		//인출
		System.out.println(queue[++front % 10]);
		
		//큐가 공백 인지 확인
		System.out.println(front == rear);
		
		//큐가 full 인지 확인
		System.out.println(((front+1)%10) == rear);
	}
}
