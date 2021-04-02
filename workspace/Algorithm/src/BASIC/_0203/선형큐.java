package BASIC._0203;

public class 선형큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Queue = new int[3];
		
		int front = -1;
		int rear = -1;
		
		for(int i=1; i<=Queue.length; i++) {
			Queue[++rear] = i;
		}
		
		for(int i=front; i<rear; i++) {
			System.out.println(Queue[++front]);
		}
		
		
	}
}
